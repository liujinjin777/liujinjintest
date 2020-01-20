package com.liujinjin.suanfa.integter;

/**
 * Created by liuxin on 17/2/5.
 */
public class T1 {

    public static void main(String[] args) {
        Integer i = 1;
        Integer i2 = 1;
        Integer a = 200;
        Integer a2 = 200;
        System.out.println(i == i2);
        System.out.println(a == a2);

        // -Djava.lang.Integer.IntegerCache.high=300

    }



}
