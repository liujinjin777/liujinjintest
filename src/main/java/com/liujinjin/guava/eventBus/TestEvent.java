package com.liujinjin.guava.eventBus;

/**
 * @author liuxin
 * @date 2017/12/4
 */
public class TestEvent {
    private final int message;
    public TestEvent(int message) {
        this.message = message;
        System.out.println("event message:"+message);
    }
    public int getMessage() {
        return message;
    }
}
