package com.liujinjin.book.head.first.observer.case2;

import com.liujinjin.book.head.first.observer.case2.impl.*;
import org.junit.Test;

/**
 * jdk 实现方式
 *
 * @author liuxin
 * @date 2018/6/19
 */
public class Main {

    @Test
    public void testMain(){
        WeatherData weatherData = new WeatherData();

        Display1 display1 = new Display1(weatherData);
        Display2 display2 = new Display2(weatherData);
        Display3 display3 = new Display3(weatherData);
        Display4 display4 = new Display4(weatherData);
        Display5 display5 = new Display5(weatherData);

        weatherData.setHumidity(1f);
        weatherData.setTemperature(2f);

        weatherData.notifyObs();
    }
}
