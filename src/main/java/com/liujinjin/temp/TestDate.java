package com.liujinjin.temp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author liuxin
 * @date 2017/12/29
 */
public class TestDate {
    public static void main(String[] args) throws ParseException {
        createDate();
    }

    public static void createDate() throws ParseException {
        String StrD ="2017-12-24";
        SimpleDateFormat sdfd =new SimpleDateFormat("yyy-MM-dd");
        Date dat =sdfd.parse(StrD);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dat);
        int weekDay = calendar.get(Calendar.DAY_OF_WEEK);
        System.out.println(StrD + "是星期" + weekDay);
    }
}
