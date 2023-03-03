package com.liujinjin.momo20221024;


import lombok.extern.slf4j.Slf4j;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Created by liuxin on 2021/6/30.
 */
@Slf4j
public class JodaDateUtil {
  public static final DateTimeFormatter yyyyMMddHHmmss =
      DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
  public static final DateTimeFormatter YYYYMMDD =  DateTimeFormat.forPattern("yyyyMMdd");
  public static final DateTimeFormatter YYYYMM =  DateTimeFormat.forPattern("yyyyMM");
  public static final DateTimeFormatter MMDD =  DateTimeFormat.forPattern("MMdd");
  public static final DateTimeFormatter DD =  DateTimeFormat.forPattern("dd");
  public static final DateTimeFormatter MMDD_V2 =  DateTimeFormat.forPattern("MM.dd");

  public static String format(long time, DateTimeFormatter formatter){
    return formatter.print(time);
  }

  public static int getTimeYYMMDD(long time) {
    return Integer.parseInt(YYYYMMDD.print(time));
  }


}
