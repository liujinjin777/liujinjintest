package com.liujinjin.book.head.first.observer.case2;

/**
 * 主题
 *
 * @author liuxin
 * @date 2018/6/19
 */
public interface Subject {

    void register(java.util.Observer observer);

    void remove(java.util.Observer observer);

    void notifyObs();

}
