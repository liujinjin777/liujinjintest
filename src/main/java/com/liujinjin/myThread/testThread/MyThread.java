package com.liujinjin.myThread.testThread;

/**
 * Created by liuxin on 2017/5/9.
 */
public class MyThread extends Thread{

    @Override
    public void run() {

        System.out.println(1);
        throw new RuntimeException();

    }
}
