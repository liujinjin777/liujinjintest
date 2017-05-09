package com.liujinjin.temp;

/**
 * Created by liuxin on 2017/4/28.
 */
public class TestResponseCode {

    static String ZERO_FILL_TEMPLATE = "%04d";

    public static void main(String[] args) {
        System.out.println(
            String.format(ZERO_FILL_TEMPLATE, 111L)
        );

        System.out.println(ZERO_FILL_TEMPLATE);
    }

}
