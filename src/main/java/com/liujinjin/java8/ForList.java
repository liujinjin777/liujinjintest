package com.liujinjin.java8;

import java.util.Comparator;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by liuxin on 2017/4/20.
 */
public class ForList {

    public static void main(String[] args) {
        List<Integer> list = asList(1, 2, 3, 4, 5, 6);

        // 1
        list.forEach(e -> System.out.print(e));
        System.out.println();

        // 2
        list.forEach((Integer e) -> System.out.print(e));
        System.out.println();

        // 3
        list.forEach(e -> {
                    System.out.print(e);
                    System.out.print(e);
                });
        System.out.println();

        list.sort((o1, o2) -> 0);

        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });

        list.forEach(e -> System.out.print(e));

        list.forEach(System.out::println);

        list.stream().map(l -> l.longValue());

    }


    public static ForList create(ForList forList){
        return forList;
    }

}
