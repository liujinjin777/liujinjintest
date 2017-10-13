package com.liujinjin.temp;

import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/**
 * Created by liuxin on 2017/9/9.
 */
public class TestLimit {

    public static void main(String[] args) {
        BitSet bitSet = new BitSet();




        System.out.println(bitSet + "--" + bitSet.size());

        System.out.println(bitSet.get(16));

        System.out.println(Long.MAX_VALUE);


        List<String> list = Arrays.asList("1", "2","3","4","5","6");
        String s1 = list.stream().reduce((s, groupId) -> s = s + "," + groupId).get() + ",";
        System.out.println(s1);
    }
}
