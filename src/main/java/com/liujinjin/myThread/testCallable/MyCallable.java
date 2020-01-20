package com.liujinjin.myThread.testCallable;

import java.util.concurrent.Callable;

/**
 * Created by liuxin on 2017/5/16.
 */
public class MyCallable implements Callable {

    private int flag = 0;

    public MyCallable(int flag){
        this.flag = flag;
    }

    public String call() throws Exception{
        if (this.flag == 0){
            System.out.println("call flag = 1");
            return "flag = 0";
        }

        if (this.flag == 1){
            try {
                while (true) {
                    System.out.println("looping.");
                    Thread.sleep(2000);
                }
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
            return "false";
        } else {
            System.out.println("Bad flag value!");
            throw new Exception("Bad flag value!");
        }

    }
}
