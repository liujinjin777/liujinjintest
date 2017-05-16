package com.liujinjin.myThread.testThread;

/**
 * Created by liuxin on 2017/5/9.
 */
public class RunMyThreadImplRunnable {

    public static void main(String[] args) {
        Thread thread = new Thread(new MyThreadImplRunable());
        thread.start();

        Thread thread1 = new Thread(thread);
    }
}
