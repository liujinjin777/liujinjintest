package com.liujinjin.temp;

import com.alibaba.fastjson.JSON;
import com.liujinjin.java8.methodReference.People;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by liuxin on 2017/9/1.
 */
public class T8 {

    public static void main(String[] args) {
        List<People> peopleList = new ArrayList<>();
        People people = new People();
        people.setAge(1);
        people.setName("people1");
        people.setId("1");
        people.setAaa(new int[]{1, 3, 5});
        People people2 = new People();
        people2.setAge(2);
        people2.setName("people2");
        people2.setId("1");

        peopleList.add(people);
        peopleList.add(people2);

        System.out.println(JSON.toJSONString(peopleList));

        Map<String, People> collect = peopleList.stream().collect(Collectors.toMap(People::getId, people1 -> people1, (key1, key2) -> key2));
        System.out.println(JSON.toJSONString(collect));

        Map<String, People> collect2 = peopleList.stream().collect(Collectors.toMap(People::getId, people1 -> people1, (t1, t2) -> t2, LinkedHashMap::new));
        System.out.println(JSON.toJSONString(collect2));


    }
}
