package com.liujinjin.myThread.testIsAlive;

/**
 * Created by liuxin on 2017/7/3.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new MyThread2();
        System.out.println("begin=" + thread.isAlive());
        Thread.sleep(1000);
        thread.start();
        System.out.println(thread.getId());
        Thread.sleep(1000);
        System.out.println("end=" + thread.isAlive());

    }



    static class MyThread2 extends Thread{
        @Override
        public void run() {
            System.out.println("run= " + this.isAlive());
        }
    }
}
