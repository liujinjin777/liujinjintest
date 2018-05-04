package com.liujinjin.aop;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author liuxin
 * @date 2018/1/7
 */
public class BaseCglibProxy implements MethodInterceptor {

    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("before-------------");
        // base的add
        Object resp = proxy.invokeSuper(object, args);
        System.out.println("after--------------");
        return resp;
    }

}


