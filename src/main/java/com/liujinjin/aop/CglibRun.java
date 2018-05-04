package com.liujinjin.aop;

/**
 * @author liuxin
 * @date 2018/1/7
 */
public class CglibRun {

    public static void main(String[] args) {
        BaseCglibProxy proxy = new BaseCglibProxy();
        // base为生成的增强过的目标类
        Base base = CglibFactory.getInstance(proxy);
        base.add();
    }

}
