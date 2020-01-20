package com.liujinjin.book.EffectiveJava;

/**
 * Created by liuxin on 17/3/2.
 */
public class AddInteger {

    // 983  8475
    public static void main(String[] args) {
        Long a = 1L;
        long start = System.currentTimeMillis();
        for(long i = 0; i<Integer.MAX_VALUE; i++){
            a += i;
        }
        System.out.println(a);
        System.out.println((System.currentTimeMillis() - start));
    }
}
