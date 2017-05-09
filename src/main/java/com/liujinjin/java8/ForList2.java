package com.liujinjin.java8;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuxin on 2017/4/21.
 */
public class ForList2 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        int sum = 0;
        list.forEach(e -> System.out.println(sum));
    }
}
