package com.liujinjin.book.head.first.observer.case1.impl;

import com.liujinjin.book.head.first.observer.case1.DisplayElement;
import com.liujinjin.book.head.first.observer.case1.Observer;
import com.liujinjin.book.head.first.observer.case1.Subject;
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
    public void display() {
        System.out.println(String.format("Display2 temperature=%s, humidity=%s", this.temp, this.humi));

    }

    @Override
    public void update() {
        this.temp = weatherData.getTemp();
        this.humi = weatherData.getHumidity();
        this.display();
    }
}
