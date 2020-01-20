package com.liujinjin.myThread.testThreadLocal;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by liuxin on 2017/7/4.
 */
public class Main {

    private static AtomicInteger nextHashCode = new AtomicInteger();

    public static void main(String[] args) {

        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        String s2 = threadLocal.get();
        System.out.println("s2= " + s2);

        threadLocal.set("1");
        threadLocal.set("2");

        String s = threadLocal.get();
        System.out.println(s);
        String s1 = threadLocal.get();
        System.out.println(s1);

        /*for (int i = 0; i < 50; i++) {
            System.out.println(nextHashCode.getAndAdd(0x61c88647));
        }*/
    }
}
