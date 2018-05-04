package com.liujinjin.guava;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by liuxin on 2017/11/1.
 */
public class T1point3 {

    public static void main(String[] args) {


        List<Integer> list = new ArrayList<>();


        System.out.println("---------------");
        List<Long> list2 =
            list.stream().map(Long::valueOf).collect(Collectors.toList());
        System.out.println("List2=  " + list2);
        list.clear();
        System.out.println(JSON.toJSONString(list));
        System.out.println(CollectionUtils.isEmpty(list));
        list.stream().forEach(i -> System.out.println(i));


        System.out.println("---------------");
        ArrayList<Integer> integers = Lists.newArrayList(1, 2, 3, 4, 57, 8);
        Collections.sort(integers, (o1, o2) -> o1 - o2);

        System.out.println(integers);


        System.out.println(System.currentTimeMillis());

        System.out.println(Long.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE);
    }
}
