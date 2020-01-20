package com.liujinjin.myThread;

import java.util.concurrent.FutureTask;

/**
 * @author liuxin
 * @date 2019/5/21
 */
public class Main {

    public static void main(String[] args) throws Exception {
        FutureTask futureTask = new FutureTask<>(new T2Task());
        FutureTask futureTask2 = new FutureTask<>(new T1Task(futureTask));

        Thread t = new Thread(futureTask);
        Thread t2 = new Thread(futureTask2);

        t2.start();
        t.start();
    }
}
