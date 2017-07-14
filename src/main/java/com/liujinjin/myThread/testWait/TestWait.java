package com.liujinjin.myThread.testWait;

/**
 * Created by liuxin on 2017/5/10.
 */
public class TestWait {

    public static void main(String[] args) throws InterruptedException {
        Object obj = new Object();
        Thread t = new Thread(() ->{
            synchronized (obj){
                System.out.println("input 1");
                try {
                    obj.wait(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("out 1");
            }
        });

        Thread t2 = new Thread(() ->{
            synchronized (obj){
                System.out.println("input 2");
                System.out.println("out 2");
            }
        });

        t.start();
        t2.start();

    }
}
