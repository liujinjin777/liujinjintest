package com.liujinjin.book.head.first.observer.case2.impl;

import com.alibaba.fastjson.JSON;
import com.liujinjin.book.head.first.observer.case2.Subject;
import lombok.Data;

import java.util.Observable;
import java.util.Observer;

/**
 * @author liuxin
 * @date 2018/6/19
 */
@Data
public class WeatherData extends Observable implements Subject {

    private float temperature;
    private float humidity;
    private float pressure;

    @Override
    public void register(Observer observer) {
        this.addObserver(observer);
    }

    @Override
    public void remove(Observer observer) {
        this.deleteObserver(observer);
    }

    @Override
    public void notifyObs() {
        super.setChanged();
        this.notifyObservers(JSON.toJSONString(this));
    }
}
