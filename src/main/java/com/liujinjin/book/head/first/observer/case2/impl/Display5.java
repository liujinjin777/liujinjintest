package com.liujinjin.book.head.first.observer.case2.impl;

import com.alibaba.fastjson.JSON;
import com.liujinjin.book.head.first.observer.DisplayElement;
import com.liujinjin.book.head.first.observer.case2.Subject;

import java.util.Observable;

/**
 * @author liuxin
 * @date 2018/6/19
 */
public class Display5 implements java.util.Observer, DisplayElement{

    private Subject subject;
    private float temperature;
    private float humidity;

    public Display5(Subject subject){
        this.subject = subject;
        subject.register(this);
    }

    @Override
    public void display() {
        System.out.println(String.format("Display5 temperature=%s, humidity=%s", this.temperature, this.humidity));
    }

    @Override
    public void update(Observable o, Object arg) {
        WeatherData weatherData = JSON.parseObject(arg.toString(), WeatherData.class);
        this.temperature = weatherData.getTemperature();
        this.humidity = weatherData.getHumidity();
        this.display();
    }
}
