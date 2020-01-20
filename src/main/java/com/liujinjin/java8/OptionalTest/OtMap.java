package com.liujinjin.java8.OptionalTest;

import com.liujinjin.java8.methodReference.People;

import java.util.Optional;

/**
 * Created by liuxin on 2017/4/24.
 */
public class OtMap {

    public static void main(String[] args) {
        People p = new People();
        p.setName("name");
        p.setAge(10);
        Optional<People> optional = Optional.ofNullable(p);
        Optional<People> optional1 = optional.filter(people -> people.getAge() == 10);
        System.out.println(optional1.orElse(null));

        //System.out.println(optional.get());
        //System.out.println(optional.orElse(new People("1", "2")));
    }
}
