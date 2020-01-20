package com.liujinjin;

/**
 * @author liuxin
 * @date 2019/1/2
 */
/*
 * 第一步：定义符合线程异常处理器规范的“异常处理器”
 * 实现Thread.UncaughtExceptionHandler规范
 */
public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler{
    /*
     * Thread.UncaughtExceptionHandler.uncaughtException()会在线程因未捕获的异常而临近死亡时被调用
     */
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("caught    "+e);
    }
}
