package com.liujinjin.suanfa.collection;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by liuxin on 17/3/6.
 */
public class LinkedHashMapTest {

    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap();
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");
    }
}
