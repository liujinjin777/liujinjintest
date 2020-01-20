package com.liujinjin.myThread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author liuxin
 * @date 2019/5/21
 */
public class T1Task implements Callable<String>{

    public FutureTask<String> t2Task;

    public T1Task(FutureTask<String> t2Task){
        this.t2Task = t2Task;
    }

    @Override
    public String call() throws Exception {

        System.out.println("水壶 " + Thread.currentThread().getName() + " " + System.currentTimeMillis());
        System.out.println("烧开水 "+ Thread.currentThread().getName() + " " + System.currentTimeMillis());
        t2Task.get();

        System.out.println("泡茶 "+ Thread.currentThread().getName() + " " + System.currentTimeMillis());

        return null;
    }
}
