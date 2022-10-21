package com.liujinjin;

import com.alibaba.fastjson.JSON;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

/**
 * Created by liuxin on 2022/2/28.
 */
public class RedissonTest {

  private static final String s = "31\n"
      + "上海\n"
      + "53\n"
      + "云南\n"
      + "11\n"
      + "北京\n"
      + "71\n"
      + "台湾\n"
      + "22\n"
      + "吉林\n"
      + "51\n"
      + "四川\n"
      + "12\n"
      + "天津\n"
      + "64\n"
      + "宁夏\n"
      + "34\n"
      + "安徽\n"
      + "37\n"
      + "山东\n"
      + "14\n"
      + "山西\n"
      + "44\n"
      + "广东\n"
      + "45\n"
      + "广西\n"
      + "65\n"
      + "新疆\n"
      + "32\n"
      + "江苏\n"
      + "36\n"
      + "江西\n"
      + "13\n"
      + "河北\n"
      + "41\n"
      + "河南\n"
      + "33\n"
      + "浙江\n"
      + "46\n"
      + "海南\n"
      + "42\n"
      + "湖北\n"
      + "43\n"
      + "湖南\n"
      + "82\n"
      + "澳门\n"
      + "62\n"
      + "甘肃\n"
      + "35\n"
      + "福建\n"
      + "54\n"
      + "西藏\n"
      + "52\n"
      + "贵州\n"
      + "21\n"
      + "辽宁\n"
      + "50\n"
      + "重庆\n"
      + "61\n"
      + "陕西\n"
      + "63\n"
      + "青海\n"
      + "81\n"
      + "香港\n"
      + "15\n"
      + "内蒙古\n"
      + "23\n"
      + "黑龙江\n"
      + "99\n"
      + "海外";

  @Test
  public void test () {
    String[] split = StringUtils.split(s, "\n");
    Map<String, String> map = new HashMap<>();
    for (int i = 0; i < split.length; i++) {
      if (i % 2 == 1) {
        map.put(split[i - 1], split[i]);
      }
    }
    System.out.println(JSON.toJSON(map));
  }

}
