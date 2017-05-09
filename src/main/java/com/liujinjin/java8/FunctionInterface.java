package com.liujinjin.java8;

import java.security.PrivilegedAction;
import java.util.concurrent.Callable;

/**
 * Created by liuxin on 2017/4/21.
 */
public class FunctionInterface {

    public static void main(String[] args) throws Exception {

        //函数式接口变成写法
        Callable<String> c = () -> "dou";
        System.out.println(c.call());

        PrivilegedAction<String> a = () -> "done";

    }
}
