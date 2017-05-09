package com.liujinjin.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Created by liuxin on 2017/4/21.
 */
public class PersionTest {

    public static void main(String[] args) {

        List<Persion> list = new ArrayList<>();
        list.add(new Persion("liuxin", 1));
        list.add(new Persion());

        // map(Function<T, R>) T=<Persion> R=String
        Stream<Integer> stream = list.stream().map(p -> p.getId());
        System.out.println();


        Supplier<Runnable> c = () -> () -> { System.out.println("hi"); };
        
    }
}
