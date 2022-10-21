package com.liujinjin;

import com.liujinjin.suanfa190622.T;
import java.util.concurrent.TimeUnit;

/**
 * Created by liuxin on 2022/3/7.
 */
public class TestRun {

  public static void main(String[] args) {
    long ts = 1L + 3600 * 24 * 1000 * 200;
    System.out.println(ts);
    long ts1 = 1L + 3600 * 24 * 1000 * 200l;
    System.out.println(ts1);
    System.out.println(Long.MAX_VALUE);

    TimeUnit.DAYS.toMillis(60);
  }
}
