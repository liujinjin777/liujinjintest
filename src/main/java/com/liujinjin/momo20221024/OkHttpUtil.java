package com.liujinjin.momo20221024;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Stopwatch;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OkHttpUtil {

  private static final Logger LOGGER = LoggerFactory.getLogger(OkHttpUtil.class);
  private static final MediaType MEDIA_TYPE = MediaType.parse("application/json; charset=utf-8");

  private static final OkHttpClient CLIENT = new OkHttpClient.Builder()
      .connectTimeout(3000, TimeUnit.MILLISECONDS)
      .readTimeout(2000, TimeUnit.MILLISECONDS)
      .build();


  /**
   * 同步get方式请求
   */
  public static String doGet(String url) {
    OkHttpClient client = new OkHttpClient();
    Request request = new Request.Builder()
        .url(url)
        .build();
    try (Response response = client.newCall(request).execute()) {
      LOGGER.info("OkHttpUtil.doGet responseCode={}, url={}", JSON.toJSONString(response.code()),
          url);
      if (response.isSuccessful() && response.body() != null) {
        return response.body().string();
      }
    } catch (Exception e) {
      LOGGER.error("OkHttpUtil.doGet error,url:{}", url, e);
    }
    return "";
  }

  public static String doPost(String url) {
    return doPost(url, Collections.emptyMap(), "{}");
  }

  public static String doPost(String url, Map<String, String> headers, String json) {
    Stopwatch stop = Stopwatch.createStarted();
    String result = null;
    try {
      Builder builder = new Builder().url(url);
      if (headers != null && !headers.isEmpty()) {
        for (Entry<String, String> entry : headers.entrySet()) {
          builder.addHeader(entry.getKey(), entry.getValue());
        }
      }
      RequestBody body = RequestBody.create(MEDIA_TYPE, json);
      Request request = builder.post(body).build();
      Response response = CLIENT.newCall(request).execute();
      if (response.body() != null) {
        result = response.body().string();
      }
      LOGGER.info("OkHttpUtil.doPost resp, code={}, message={}, cost:{}ms, url:{}", response.code(),
          response.message(), stop.elapsed(TimeUnit.MILLISECONDS), url);
    } catch (Exception e) {
      LOGGER.error("OkHttpUtil.doPost error,url:{}", url, e);
    }
    return result;
  }
}
