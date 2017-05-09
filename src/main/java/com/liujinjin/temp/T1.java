package com.liujinjin.temp;

import com.liujinjin.java8.methodReference.People;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liuxin on 2017/4/25.
 */
public class T1 {

    public static void main(String[] args) {
        List<People> list = new ArrayList<>();
        list.add(new People());

        Map<String, List<People>> map = new HashMap<>();
        map.put("1", list);

        test(map);

        System.out.println(map);
    }

    private static void test(Map<String, List<People>> map) {
        List<People> list = map.get("1");
        list.add(new People("1", "name"));
    }
}
