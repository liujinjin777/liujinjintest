package com.liujinjin.myThread.testWait;

/**
 * Created by liuxin on 2017/5/10.
 */
public class Run {

    public static void main(String[] args) throws InterruptedException {
        Object obj = new Object();

        //synchronized (obj) {
            obj.notify();
            //obj.wait(1000);
            System.out.println(1);
        //}
    }
}
