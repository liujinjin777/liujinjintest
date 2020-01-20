package com.liujinjin.myThread.testThreadLocal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuxin on 2017/7/10.
 */
public class TestMapSize {


    public static void main(String[] args) {
        List<ThreadLocal<String>> list = new ArrayList<>();
        for(int i=0; i<20; i++) {
            ThreadLocal<String> threadLocal = new ThreadLocal<>();
            threadLocal.set(String.valueOf(i));
            list.add(threadLocal);
        }

        Thread thread = Thread.currentThread();
        System.out.println("11");
    }
}
