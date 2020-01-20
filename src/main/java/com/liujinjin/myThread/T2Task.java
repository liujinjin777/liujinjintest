package com.liujinjin.myThread;

import java.util.concurrent.Callable;

/**
 * @author liuxin
 * @date 2019/5/21
 */
public class T2Task implements Callable<String> {


    @Override
    public String call() throws Exception {
        Thread.sleep(2000L);
        System.out.println("洗茶壶"+ Thread.currentThread().getName() + " " + System.currentTimeMillis());
        System.out.println("洗茶杯"+ Thread.currentThread().getName() + " " + System.currentTimeMillis());
        System.out.println("拿茶叶"+ Thread.currentThread().getName() + " " + System.currentTimeMillis());

        return null;
    }
}
