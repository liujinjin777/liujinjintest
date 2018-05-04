package com.liujinjin.guava;

import java.util.Optional;

/**
 * @author liuxin
 * @date 2017/12/18
 */
public class TestNull {

    public static void main(String[] args) {


        Optional<Integer> of = Optional.of(6);
        Optional<Object> optional = Optional.ofNullable(null);

        System.out.println(optional.orElse(1) + "获取值，当存入引用为null，返回默认值");
        System.out.println(optional.isPresent() + "是否包含引用");
        System.out.println(optional.get() + "获取值，当为null时，抛出错误");
    }
}
