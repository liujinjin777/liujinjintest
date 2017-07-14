package com.liujinjin.myThread.testPriority;

/**
 * Created by liuxin on 2017/7/3.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {

        ThreadA threadA = new ThreadA();
        ThreadA threadB = new ThreadA();

        threadA.setPriority(+3);
        threadB.setPriority(+7);

        threadA.start();
        threadB.start();

        Thread.sleep(2000L);
        threadA.stop();
        threadB.stop();

        System.out.println(threadA.getCount());
        System.out.println(threadB.getCount());


    }
}
