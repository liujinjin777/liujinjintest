package com.liujinjin.myThread.testnotify;

/**
 * Created by liuxin on 2017/5/3.
 */
public class SynNotifyMethodThread extends Thread {
    private Object lock;
    public SynNotifyMethodThread(Object lock){
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        Service service = new Service();
        service.syNotifyMethod(lock);
    }

}
