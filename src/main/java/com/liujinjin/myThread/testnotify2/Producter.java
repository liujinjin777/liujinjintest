package com.liujinjin.myThread.testnotify2;

import java.util.Vector;

/**
 * Created by liuxin on 2017/5/10.
 */
public class Producter implements Runnable {
    private Vector obj;

    public Producter(Vector v) {
        this.obj = v;
    }

    public void run() {
        synchronized (obj) {
            while (true) {
                try {
                    if (obj.size() != 0) {
                        obj.wait();
                    }

                    obj.add(new String("apples"));
                    obj.notify();
                    System.out.println("Producter:obj are ready");
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
