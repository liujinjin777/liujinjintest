package com.liujinjin.book.GoodCoding.Advice6;

/**
 * Created by liuxin on 17/3/17.
 */
public class Run {

    public static void main(String[] args) {
        Base base = new Sub();
        base.fun(100, 50);

        Sub sub = new Sub();
        //sub.fun(100, 50);
    }
}
