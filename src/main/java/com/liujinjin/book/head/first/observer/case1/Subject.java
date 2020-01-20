package com.liujinjin.book.head.first.observer.case1;

/**
 * 主题
 *
 * @author liuxin
 * @date 2018/6/19
 */
public interface Subject {

    void register(Observer observer);

    void remove(Observer observer);

    void notifyObs();

    float getTemp();

    float getHumidity();

}
