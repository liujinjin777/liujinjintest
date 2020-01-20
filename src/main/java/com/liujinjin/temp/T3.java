package com.liujinjin.temp;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by liuxin on 2017/7/25.
 */
public class T3 {

    public static void main(String[] args) {
        Map<String, Object> map = new TreeMap<>();

        map.put("aa", 1);
        map.put("f", 1);
        map.put("d", 1);
        map.put("b", 1);
        map.put("ab", 1);
        map.put("ac", 1);

        System.out.println(map);
    }
}
