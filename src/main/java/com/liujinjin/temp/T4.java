package com.liujinjin.temp;

import java.util.Arrays;

/**
 * Created by liuxin on 2017/8/1.
 */
public class T4 {

    public static void main(String[] args) {

        String a ="123123|、";
        String[] split = a.split("\\|");
        System.out.println(Arrays.toString(split));

        System.out.println(a.contains("|"));
        System.out.println(a.contains("|"));

        String[] split1 = a.split("、");
        System.out.println(Arrays.toString(split1));
        System.out.println(a.contains("、"));
    }
}
