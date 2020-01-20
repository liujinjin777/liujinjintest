package com.liujinjin.myThread.testnotify;

/**
 * Created by liuxin on 2017/5/3.
 */
public class ThreadA extends Thread{
    private Object lock;
    public ThreadA(Object lock){
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        Service service = new Service();
        service.testMethod(lock);
    }
}
