package com.liujinjin.java8;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by liuxin on 2017/4/21.
 */
@Setter
@Getter
@ToString
public class Persion {
    String name;
    Integer id;

    Persion(){}

    Persion(String name, Integer id){
        this.name = name;
        this.id = id;
    }
}
