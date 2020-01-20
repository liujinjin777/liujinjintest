package com.liujinjin.java8.methodReference;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

/**
 * Created by liuxin on 2017/4/24.
 */
public class Main {

    /**
     * Supplier
     * Consumer
     *
     * @param args
     */
    public static void main(String[] args) {
        // Class::new
        Car car = Car.create(Car::new);
        Car car1 = Car.create(Car::new);
        Car car2 = Car.create(Car::new);
        System.out.println(car == car1);

        // Class::static_method
        List<Car> cars = Arrays.asList(car, car1);
        cars.forEach(Car::collide);

        // Class::method
        cars.forEach(Car::repair);

        // instance::method
        cars.forEach(car1::follow);
        //System.out.println(Car::follow);


        Integer integer = 11;
        BiFunction<String, Integer, Integer> stringIntegerIntegerBiFunction = Integer::valueOf;
    }
}
