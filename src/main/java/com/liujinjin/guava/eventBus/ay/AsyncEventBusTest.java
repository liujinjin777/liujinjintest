package com.liujinjin.guava.eventBus.ay;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.Subscribe;

import java.util.concurrent.Executors;

/**
 * @author liuxin
 * @date 2017/12/11
 */
public class AsyncEventBusTest {

    public static int sum;

    public static void main(String[] args) {
        new AsyncEventBusTest().test();
    }

    public void test(){
        AsyncEventBus asyncEventBus = new AsyncEventBus(Executors.newFixedThreadPool(10));
        asyncEventBus.register(new Object(){
            @Subscribe
            public void listen(int num){
                sum += num;
            }
        });
        for(int i = 0; i < 10; i++) {
            asyncEventBus.post(1);
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(sum);
    }
}
