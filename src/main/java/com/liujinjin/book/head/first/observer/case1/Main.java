package com.liujinjin.book.head.first.observer.case1;

import com.liujinjin.book.head.first.observer.case1.impl.Display1;
import com.liujinjin.book.head.first.observer.case1.impl.Display2;
import com.liujinjin.book.head.first.observer.case1.impl.WeatherData;
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

        weatherData.setHumidity(0.01f);
        weatherData.setTemp(0.02f);
        weatherData.notifyObs();
    }
}
