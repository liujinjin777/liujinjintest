package com.liujinjin.myThread.testSleep;

/**
 * Created by liuxin on 2017/5/8.
 */
public class TestSleep {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            synchronized (TestSleep.class){
                System.out.println("11111");
                try {
                    Thread.sleep(5000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("22222");
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (TestSleep.class){
                System.out.println("333333");
                System.out.println("444444");
            }
        });

        thread.start();
        thread2.start();
        //Thread.sleep(1000L);
    }
}
