package com.liujinjin.book.head.first.observer.case0.impl;

import com.liujinjin.book.head.first.observer.Observer;
import org.junit.Test;

/**
 * @author liuxin
 * @date 2018/6/19
 */
public class Main {

    @Test
    public void testRun(){
        WeatherData weatherData = new WeatherData();

        Observer display1 = new Display1(weatherData);
        Observer display2 = new Display2(weatherData);

        weatherData.setHumi(0.01f);
        weatherData.setPre(0.02f);
        weatherData.notifyObs();
    }
}
