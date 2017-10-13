package com.liujinjin.book.javaer.t88;

/**
 * Created by liuxin on 2017/9/4.
 */
public class CarFactory {

    public static Car cearteCar(Class<? extends Car> c){
        try {
            return (Car) c.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
