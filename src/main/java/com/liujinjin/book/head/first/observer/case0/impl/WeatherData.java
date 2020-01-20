package com.liujinjin.book.head.first.observer.case0.impl;

import com.google.common.collect.Sets;
import com.liujinjin.book.head.first.observer.Observer;
import com.liujinjin.book.head.first.observer.Subject;
import lombok.Data;

import java.util.Set;

/**
 * @author liuxin
 * @date 2018/6/19
 */
@Data
public class WeatherData implements Subject {

    private Set<Observer> observers = Sets.newHashSet();
    private float temp;
    private float humi;
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
        observers.forEach(observer -> observer.update(temp, humi, pre));
    }
}
