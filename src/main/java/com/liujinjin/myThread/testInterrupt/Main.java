package com.liujinjin.myThread.testInterrupt;

/**
 * Created by liuxin on 2017/5/25.
 */
public class Main {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                //e.printStackTrace();
                System.out.println("thread be interrupted");
            }
        });

        thread.start();
        thread.interrupt();

    }
}
