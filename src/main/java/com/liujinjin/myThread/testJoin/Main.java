package com.liujinjin.myThread.testJoin;

/**
 * Created by liuxin on 2017/4/28.
 */
public class Main {
    static volatile int a = 0;
    public static void main(String[] args) throws InterruptedException {

        Thread threadA = new Thread( () -> {
            while(true) {
                if(a == 0) {
                    System.out.println("a");
                    a++;
                    break;
                }

            }
        });

        Thread threadB = new Thread( () -> {
            while(true) {
                if(a == 1) {
                    System.out.println("b");
                    a++;
                    break;
                }
            }
        });

        Thread threadC = new Thread( () -> {
            while(true) {
                if(a == 2) {
                    System.out.println("c");
                    a++;
                    break;
                }
            }
        });

        Thread threadD = new Thread( () -> {
            while(true) {
                if(a == 3) {
                    System.out.println("d");
                    a++;
                    break;
                }
            }
        });


        threadD.start();
        threadC.start();
        threadB.start();
        threadA.start();



    }



}
