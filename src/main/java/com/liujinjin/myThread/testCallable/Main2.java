package com.liujinjin.myThread.testCallable;

import java.util.concurrent.FutureTask;

/**
 * Created by liuxin on 2017/5/16.
 */
public class Main2 {

    public static void main(String[] args) {
        MyCallable task1 = new MyCallable(0);
        MyCallable task2 = new MyCallable(2);

        FutureTask<MyCallable> oneTask1 = new FutureTask<MyCallable>(task1);
        FutureTask<MyCallable> oneTask2 = new FutureTask<MyCallable>(task2);

        Thread thread = new Thread(oneTask1);
        Thread thread2 = new Thread(oneTask2);

        thread.start();
        thread2.start();
    }
}
