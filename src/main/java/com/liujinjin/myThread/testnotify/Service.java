package com.liujinjin.myThread.testnotify;

/**
 * Created by liuxin on 2017/5/3.
 */
public class Service {
    public void testMethod(Object lock) {
        try {
            synchronized (lock) {
                System.out.println("begin wait() threadName+"
                        + Thread.currentThread());
                lock.wait();
                System.out.println("end wait() threadName+"
                        + Thread.currentThread());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void syNotifyMethod(Object lock) {
        synchronized (lock) {
            System.out.println("begin notify() threadName+"
                    + Thread.currentThread().getName() + " time=" +
                    System.currentTimeMillis());
            lock.notify();
            System.out.println("end notify() threadName+"
                    + Thread.currentThread().getName() + " time=" +
                    System.currentTimeMillis());
        }
    }


}
