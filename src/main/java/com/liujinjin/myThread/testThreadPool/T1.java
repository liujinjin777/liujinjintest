package com.liujinjin.myThread.testThreadPool;

import java.util.concurrent.*;

/**
 * Created by liuxin on 2017/8/9.
 */
public class T1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Runnable runnable = () -> System.out.println("1111");

        Callable<String> callable = () -> "11111";

        // 固定线程数
        ExecutorService fixedExecutorService = Executors.newFixedThreadPool(10);
        //fixedExecutorService.execute(runnable);
        Future<String> submit = fixedExecutorService.submit(callable);
        System.out.println("2221");
        String s = submit.get();
        System.out.println("返回值：" + s);
        fixedExecutorService.shutdown();

        // 默认有60s缓存线程
        ExecutorService cachedExecutorService = Executors.newCachedThreadPool();

        // 单个线程
        ExecutorService singleExecutorService = Executors.newSingleThreadExecutor();

        // 可以延迟或定期执行任务
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);

        //ThreadPoolExecutor
    }






}






