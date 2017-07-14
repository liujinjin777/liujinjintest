package com.liujinjin.myThread.testThreadLocal;

import com.liujinjin.java8.methodReference.People;

/**
 * Created by liuxin on 2017/7/5.
 */
public class Main2 {

    private static ThreadLocal<People> threadLocal = null;

    static {
        People people = new People();
        threadLocal = ThreadLocal.withInitial(() -> people);
    }

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println( Thread.currentThread().getName() + "  " +threadLocal.get());
        });


        System.out.println( Thread.currentThread().getName() + "  " +threadLocal.get());

        thread.start();
    }
}
