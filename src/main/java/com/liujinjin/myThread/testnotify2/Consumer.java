package com.liujinjin.myThread.testnotify2;

import java.util.Vector;

/**
 * Created by liuxin on 2017/5/10.
 */
public class Consumer implements Runnable {
    private Vector obj;

    public Consumer(Vector v) {
        this.obj = v;
    }

    public void run() {
        synchronized (obj) {
            while (true) {
                try {
                    if (obj.size() == 0) {
                        obj.wait();
                    }
                    System.out.println("Consumer:goods have been taken");
                    System.out.println("obj size: " + obj.size());
                    obj.clear();
                    obj.notify();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
