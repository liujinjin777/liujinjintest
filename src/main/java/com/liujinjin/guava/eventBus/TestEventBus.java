package com.liujinjin.guava.eventBus;

import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author liuxin
 * @date 2017/12/4
 */
public class TestEventBus {

    private static int sum;

    public static void main(String[] str) throws InterruptedException {
       testSimpleDemo();
       // testAsyncDemo();

    }

    /**
     * 1，按照post方法传入的类型或者是类型的子类匹配。
     * 3，如果有多个类型匹配，可以进入多个方法中。
     * 4，如果没有，会被封装到deadEvent对象中
     */
    public static void testSimpleDemo() throws InterruptedException {
        // 1, new一个eventBus对象
        EventBus eventBus = new EventBus();

        // 2, 注册观察类
        eventBus.register(new Object(){
            @Subscribe
            @AllowConcurrentEvents
            public void listerInteger(Integer num){
                sum++;
            }
        });

        // 3, 发送1
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        for(int i = 0; i < 20; i++) {
            executorService.execute(() -> {
                eventBus.post(1);
            });
        }

        Thread.sleep(3000L);
        System.out.println(sum);
        executorService.shutdownNow();
    }

    public static void testAsyncDemo(){
        // 1, new一个eventBus对象
        AsyncEventBus eventBus = new AsyncEventBus(Executors.newFixedThreadPool(10));

        // 2, 注册观察类
        eventBus.register(new Object(){
            @Subscribe
            public void lister(Integer num){
                System.out.println(num + "thread name :" + Thread.currentThread().getName());
            }
        });

        // 3, 发送1
        eventBus.post(1);
        eventBus.post(1);
        eventBus.post(1);
    }

}