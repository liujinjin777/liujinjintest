package com.liujinjin.book.javaer.t89;

import java.util.EnumSet;

/**
 * Created by liuxin on 2017/9/4.
 */
public class Main {

    public static void main(String[] args) {
        EnumSet<P> ps = EnumSet.allOf(P.class);
        System.out.println(ps);
    }
}
