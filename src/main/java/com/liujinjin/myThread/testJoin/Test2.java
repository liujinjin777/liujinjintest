package com.liujinjin.myThread.testJoin;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by liuxin on 2017/4/28.
 */
public class Test2 {

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread( () -> {
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("a");
        });

        Thread threadB = new Thread( () -> {
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("b");
        });
        Thread threadC = new Thread( () -> {
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("c");
        });
        Thread threadD = new Thread( () -> {
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("d");
        });

        AtomicInteger num = new AtomicInteger(0);
        if(num.get() == 0){
            threadA.start();
            num.incrementAndGet();

            if(num.get() == 1){
                threadB.start();
                num.incrementAndGet();

                if(num.get() == 2){
                    threadC.start();
                    num.incrementAndGet();

                    if(num.get() == 3){
                        threadD.start();
                        num.incrementAndGet();
                    }
                }
            }
        }



//        threadB.start();
//        threadB.join();
//
//        threadC.start();
//        threadC.join();
//
//        threadD.start();
//        threadD.join();

    }


}
