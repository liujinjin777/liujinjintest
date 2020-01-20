package com.liujinjin.book.head.first.observer.case1.impl;

import com.google.common.collect.Lists;
import com.liujinjin.book.head.first.observer.case1.Observer;
import com.liujinjin.book.head.first.observer.case1.Subject;
import lombok.Data;

import java.util.List;

/**
 * @author liuxin
 * @date 2018/6/19
 */
@Data
public class WeatherData implements Subject {

    private List<Observer> observers = Lists.newArrayList();
    private float temp;
    private float humidity;
    private float pre;

    @Override
    public void register(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObs() {
        observers.forEach(Observer::update);
    }
}
