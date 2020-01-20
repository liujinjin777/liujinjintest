package com.liujinjin.book.head.first.observer.case0.impl;

import com.liujinjin.book.head.first.observer.DisplayElement;
import com.liujinjin.book.head.first.observer.Observer;
import com.liujinjin.book.head.first.observer.Subject;
import lombok.Data;

/**
 * @author liuxin
 * @date 2018/6/19
 */
@Data
public class Display2 implements DisplayElement, Observer {

    private float temp;
    private float humi;
    private Subject weatherData;

    public Display2(Subject weatherData){
        this.weatherData = weatherData;
        weatherData.register(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humi = humidity;
        display();
    }

    @Override
    public void display() {
        System.out.println(String.format("Display2 temperature=%s, humidity=%s", this.temp, this.humi));

    }
}
