package com.liujinjin.aop;

import net.sf.cglib.proxy.Enhancer;

/**
 * @author liuxin
 * @date 2018/1/7
 */
public class CglibFactory {

    public static Base getInstance(BaseCglibProxy proxy) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Base.class);
        //回调方法的参数为代理类对象CglibProxy，最后增强目标类调用的是代理类对象CglibProxy中的intercept方法
        enhancer.setCallback(proxy);
        // 此刻，base不是单纯的目标类，而是增强过的目标类
        Base base = (Base) enhancer.create();
        return base;
    }

}
