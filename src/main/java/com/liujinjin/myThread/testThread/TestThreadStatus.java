package com.liujinjin.myThread.testThread;

/**
 * Created by liuxin on 2017/5/15.
 */
public class TestThreadStatus {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            synchronized (TestThreadStatus.class) {
                System.out.println("111");
                System.out.println("111");
                try {
                    Thread.sleep(5000L * 10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            synchronized (TestThreadStatus.class) {
                System.out.println("111");
                System.out.println("111");
            }
        });

        thread.start();
        thread2.start();
        System.out.println(thread2.getState());
        thread2.getName();



    }
}
