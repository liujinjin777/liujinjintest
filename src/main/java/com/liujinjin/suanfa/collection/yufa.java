package com.liujinjin.suanfa.collection;

import java.util.Arrays;
import java.util.List;

/**
 * Created by liuxin on 17/2/5.
 */
public class yufa {

    public static void main(String[] args) {

        List<String> strings = Arrays.asList("a", "b", "c");
        System.out.println(strings);


        int[] a = {0, 6, 2, 3};
        System.out.println(Arrays.binarySearch(a, 2));


        System.out.println(Arrays.toString(a));
    }

}
