package com.liujinjin.book.head.first.observer;

/**
 * @author liuxin
 * @date 2018/6/19
 */
public interface Observer {

    void update(float temp, float humidity, float pressure);

}
