package com.liujinjin.java8.methodReference;

import lombok.Data;

/**
 * Created by liuxin on 2017/4/24.
 */
@Data
public class People {

    String id;
    String name;
    int age;
    int[] aaa;
    Boolean flag = true;

    public People() {}

    public People(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
