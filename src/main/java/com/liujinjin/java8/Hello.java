package com.liujinjin.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by liuxin on 2017/4/21.
 */
public class Hello {
    Runnable r1 = () -> System.out.println(this);
    Runnable r2 = () -> System.out.println(toString());

    @Override
    public String toString() {
        return "Hello, world";
    }

    public static void main(String... args) {
        Stream<List<Integer>> inputStream = Stream.of(
                Arrays.asList(1),
                Arrays.asList(2, 3),
                Arrays.asList(4, 5, 6)
        );
        List<Integer> collect = inputStream.
                flatMap((childList) -> childList.stream()).collect(Collectors.toList());

        collect.forEach(System.out::print);


    }


}
