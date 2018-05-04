package com.liujinjin.guava.eventBus;

import com.google.common.eventbus.Subscribe;

/**
 * @author liuxin
 * @date 2017/12/4
 */
public class EventListener {
    public int lastMessage = 0;

    @Subscribe
    //@AllowConcurrentEvents
    public void listen(TestEvent event) {
        lastMessage = event.getMessage();
        System.out.println("Message:" + lastMessage + " name:" + Thread.currentThread().getName());
        System.out.println();
    }

    public int getLastMessage() {
        return lastMessage;
    }
}