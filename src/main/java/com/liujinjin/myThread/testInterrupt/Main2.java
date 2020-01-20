package com.liujinjin.myThread.testInterrupt;

/**
 * Created by liuxin on 2017/7/3.
 */
public class Main2 {


    public static void main(String[] args) {
        Thread.currentThread().interrupt();

        System.out.println(Thread.interrupted());
        //System.out.println(Thread.interrupted());
        System.out.println(Thread.currentThread().isInterrupted());
        System.out.println(Thread.currentThread().isInterrupted());

        System.out.println("end!");
    }
}
