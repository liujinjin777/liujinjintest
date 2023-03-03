package com.liujinjin.momo20221024;

import com.alibaba.fastjson.JSON;
import com.liujinjin.book.javaer.t88.Car;
import com.liujinjin.momo20221024.bean.CardInfo;
import com.liujinjin.momo20221024.bean.RoundInfo;
import org.apache.commons.lang3.BooleanUtils;

/**
 * Created by liuxin on 2022/10/21.
 */
public class Momo1024HttpService {

  private static final String userToken = "d5f44ba8-8a17-433b-a988-f968dd384c0f";
  private static final String domainUrl = "https://1024.hellogroup.com";


  public static boolean cardReady() {
    String url = domainUrl + "/card/ready?userToken=" + userToken;
    String resp = OkHttpUtil.doPost(url);
    return BooleanUtils.toBoolean(resp);
  }

  public static CardInfo cardInfo() {
    String url = domainUrl + "/card/info?userToken=" + userToken;
    url += "&startTime=1666321200000&endTime=1666360800000";
    String resp = OkHttpUtil.doGet(url);
    return JSON.parseObject(resp, CardInfo.class);
  }

  public static RoundInfo roundInfo(int roundNum) {
    String url = domainUrl + "/card/roundInfo?userToken=" + userToken;
    url += "&roundNum=" + roundNum;
    String resp = OkHttpUtil.doGet(url);
    return JSON.parseObject(resp, RoundInfo.class);
  }

  public static boolean operate(int roundNum, String sortNums) {
    String url = domainUrl + "/card/operate?userToken=" + userToken;
    url += "&roundNum=" + roundNum;
    url += "&cardsInfo=" + sortNums;
    String resp = OkHttpUtil.doPost(url);
    return BooleanUtils.toBoolean(resp);
  }
}
