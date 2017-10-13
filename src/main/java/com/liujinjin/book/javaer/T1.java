package com.liujinjin.book.javaer;

import java.util.ArrayList;
import java.util.List;

/**
 * 编写高质量代码100多个建议
 * Created by liuxin on 2017/8/21.
 */
public class T1 {

    private static int i = 0;

    static {
        i = 100;
    }

    public static void example(){

    }

    public static void main(String[] args) {
        //t2();
        System.out.println(i);
    }



    public static void t2(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        //list.add(null);

        int sum = 0;
        for(int i : list){
            sum += i;
        }
        System.out.println(sum);
    }

    public static void t1(){
        int i = 1;
        i = ++i;
        System.out.println(i);

        int b = 1;
        b = b++;
        System.out.println(b);
    }
}
