package com.liujinjin.study.DateStudy;

import com.alibaba.fastjson.JSON;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 参考：https://www.cnblogs.com/manue1/p/4495983.html
 *
 * @author liuxin
 * @date 2017/12/29
 */
public class Test {

    public static void main(String[] args) throws Exception {

        //testDiffSqlAndUtil();
        //testSimpleDateFormat();
        //testCalendar();
        testDateY("2015-12-31 11:22:45");
    }

    public static void testDateY(String str) throws ParseException {
        //String str ="2010-12-31 11:22:45";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date =dateFormat.parse(str);
        System.out.println(date);
        System.out.println(JSON.toJSONString(date));

        SimpleDateFormat strFormat = new SimpleDateFormat("Y-M-d(E) (a)HH:mm:ss");
        String formatDate = strFormat.format(date);
        System.out.println(formatDate);
    }

    public static void testCalendar(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2015);
        calendar.set(Calendar.MONTH, 1); // 0+1 月
        calendar.set(Calendar.DATE, 12);


        // 转为date
        Date date = calendar.getTime();
        calendar.setTime(date);
        SimpleDateFormat strFormat = new SimpleDateFormat("yyyy-MM-dd(E) (a)HH:mm:ss");
        String formatDate = strFormat.format(date);
        System.out.println(formatDate);

        //获取年月日、星期几、年的第几天
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH); // 0=1月 ... 11=12月
        int day = calendar.get(Calendar.DATE);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK); // 0=星期六 1=星期天 2=星期一 3=星期二 ...
        int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
        System.out.println(year + " " + month + " " + day);
        System.out.println("dayOfMonth=" + dayOfMonth + " dayOfWeek=" + dayOfWeek + " dayOfYear=" + dayOfYear);

        //获取年最大天数、月最大天数
        Calendar calendarMax = Calendar.getInstance();
        int monthMaxDay = calendarMax.getActualMaximum(Calendar.DAY_OF_MONTH);
        int yearMaxDay = calendarMax.getActualMaximum(Calendar.DAY_OF_YEAR);
        System.out.println("monthMaxDay=" + monthMaxDay + " yearMaxDay=" + yearMaxDay);

        //add
        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.HOUR, -1);
        Date date2 = calendar.getTime();
        SimpleDateFormat strFormat2 = new SimpleDateFormat("yyyy-MM-dd(E) (a)HH:mm:ss");
        String formatDate2 = strFormat.format(date2);
        System.out.println(formatDate2);
    }

    public static void testSimpleDateFormat() throws ParseException {
        String str ="2015-04-20 11:22:45";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date =dateFormat.parse(str);
        System.out.println(date);

        SimpleDateFormat strFormat = new SimpleDateFormat("y-M-d(E) (a)HH:mm:ss");
        String formatDate = strFormat.format(date);
        System.out.println(formatDate);
    }

    /**
     * 问题一，java.sql.Date和java.util.Date有什么区别？
     *    1,sql extends util
     *    2,sql只有日期没有时间部分
     *
     */
    public static void testDiffSqlAndUtil(){
        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());

        System.out.println(date);  //Fri Dec 29 15:40:36 CST 2017
        System.out.println(sqlDate); //2017-12-29
    }


}
