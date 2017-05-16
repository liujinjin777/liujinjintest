package com.liujinjin.myThread.testnotify2;

import java.util.Vector;

/**
 * Created by liuxin on 2017/5/10.
 */
public class Run {

    public static void main(String[] args) {
        Vector obj = new Vector();
        Thread consumer = new Thread(new Consumer(obj));
        Thread producter = new Thread(new Producter(obj));
        consumer.start();
        producter.start();

    }
}
