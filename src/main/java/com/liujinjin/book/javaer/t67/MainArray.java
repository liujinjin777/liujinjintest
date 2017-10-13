package com.liujinjin.book.javaer.t67;

import java.util.Random;

/**
 * Created by liuxin on 2017/8/24.
 */
public class MainArray {

    public static void main(String[] args) {
        int num = 800 * 10000;
        int[] a = new int[num];

        for(int i = 0; i < a.length; i++){
            a[i] = new Random().nextInt(150);
        }

        long start = System.currentTimeMillis();
        System.out.println("平均分是：" + getSum(a));
        System.out.println("执行时间："+ (System.currentTimeMillis() - start) + "ms");
    }
    // 800w 6
    public static int getSum(int[] a){
        int sum = 0;
        for(int temp : a){
            sum += temp;
        }
        return sum;
    }

    public static int getSum2(int[] a){
        int sum = 0;
        for(int i = 0; i < a.length; i++){
            sum += a[i];
        }
        return sum;
    }
}
