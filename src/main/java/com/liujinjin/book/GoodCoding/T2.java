package com.liujinjin.book.GoodCoding;

import java.util.Arrays;

/**
 * Created by liuxin on 17/3/18.
 *
 * 测试, 分隔
 */
public class T2 {

    public static void main(String[] args) {
        String s = "asd";
        String s2 = "asd,asd";
        System.out.println(Arrays.toString(s.split(",")));
        System.out.println(Arrays.toString(s2.split(",")));
    }
}
