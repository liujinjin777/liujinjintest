package com.liujinjin.myThread.testThread;

/**
 * Created by liuxin on 2017/5/9.
 */
public class RunMyThread {

    public static void main(String[] args) {
        MyThread thread = new MyThread();

        try {
            thread.start();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
