package com.liujinjin.myThread.testnotify;

/**
 * Created by liuxin on 2017/5/3.
 */
public class Run {

    public static void main(String[] args) {
        Object lock = new Object();
        ThreadA a = new ThreadA(lock);
        a.start();
        NotifyThread notifyThread = new NotifyThread(lock);
        notifyThread.start();
        SynNotifyMethodThread c = new SynNotifyMethodThread(lock);
        c.start();
    }
}
