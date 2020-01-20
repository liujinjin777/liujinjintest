package com.liujinjin.book.javaer.t67;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by liuxin on 2017/8/24.
 */
public class Main {

    public static void main(String[] args) {

        int stuNum = 800 * 10000;
        List<Integer> scores = new ArrayList<>(stuNum);

        for(int i = 0; i < stuNum; i++){
            scores.add(new Random().nextInt(150));
        }

        long start = System.currentTimeMillis();
        System.out.println("平均分是：" + average(scores));
        System.out.println("执行时间："+ (System.currentTimeMillis() - start) + "ms");
    }

    // 80w  800w
    // 12ms 94ms
    public static int average(List<Integer> list){
        int sum = 0;
        for(int i:list){
            sum+=list.get(i);
        }
        return sum/list.size();
    }
    // 80w 800w
    // 6ms 59ms
    public static int average2(List<Integer> list){
        int sum = 0;
        for(int i = 0; i < list.size(); i++){
            sum+=list.get(i);
        }
        return sum/list.size();
    }
}
