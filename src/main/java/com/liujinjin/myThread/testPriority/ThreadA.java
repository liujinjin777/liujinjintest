package com.liujinjin.myThread.testPriority;

/**
 * Created by liuxin on 2017/7/3.
 */
public class ThreadA extends Thread {

    private  int count = 0;

    @Override
    public void run() {
        while(true){
            count++;
        }
    }

    public int getCount(){
        return count;
    }
}
