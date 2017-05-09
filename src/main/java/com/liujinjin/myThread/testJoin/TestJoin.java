package com.liujinjin.myThread.testJoin;

/**
 * Created by liuxin on 2017/5/8.
 */
public class TestJoin {

        public static void main(String[] args) throws InterruptedException {

            Thread threadA = new Thread( () -> {
                        System.out.println("a");

            });

            Thread threadB = new Thread( () -> {
                        System.out.println("b");
            });

            Thread threadC = new Thread( () -> {
                        System.out.println("c");
            });

            Thread threadD = new Thread( () -> {
                        System.out.println("d");
            });


            threadD.start();
            threadD.join();
            threadC.start();
            threadC.join();
            threadB.start();
            threadB.join();
            threadA.start();
            threadA.join();






    }

}
