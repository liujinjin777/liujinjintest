package com.liujinjin.suanfa.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by liuxin on 17/3/9.
 */
public class GetNum {

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(get(1))
        );
    }

    public static int[] get(int n){
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 1; i <= 100; i++){
            list.add(i);
        }

        int[] array = new int[n];
        for(int i = 0; i < n; i++){
            int j = (int) (Math.random() * list.size());
            int num = list.get(j);
            array[i] = num;

            // 58二面面试官非说有问题, 哼,这不是没问题吗
            list.remove(j);
        }
        System.out.println(list);
        return array;
    }



}
