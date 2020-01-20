package com.liujinjin.myThread.testReference;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * Created by liuxin on 2017/7/4.
 */
public class Main {

    public static void main(String[] args) {
        Map<String, String> list = new WeakHashMap<>();
        long i = 1;
        while (i < 100000000L) {
            list.put(
                    String.valueOf(i),
                    "JDJJDJJJJJJJJJJ%%%%%%%%JJJJJJJJJJJJJJJKKKKKKKKKKKKKKKKKJJJJJJ"
                            + "JJJKKKKKHDDDJDJDJDJDJDJDJDJJDJDJDJDJDJDJJDJDJDJDJJDJDJJJJJJJJJ"
                            + "JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ"
                            + "JJJJJJJJJJJJJJJJJJJJJJJJJJJJ");

            // 测试第一个是否依然存活
            if (i % 100000 == 0) {
                System.out.println(list.get(String.valueOf(1)));
            }
            //list.clear();
            i++;
        }

    }
}
