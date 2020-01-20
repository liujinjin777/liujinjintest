package com.liujinjin.myThread.testThreadLocal;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by liuxin on 2017/7/10.
 */
public class TestKey {

    private final int threadLocalHashCode = nextHashCode();

    /**
     * The next hash code to be given out. Updated atomically. Starts at
     * zero.
     */
    private static AtomicInteger nextHashCode = new AtomicInteger();

    /**
     * The difference between successively generated hash codes - turns
     * implicit sequential thread-local IDs into near-optimally spread
     * multiplicative hash values for power-of-two-sized tables.
     */
    private static final int HASH_INCREMENT = 0x61c88647;

    private static int nextHashCode() {
        return nextHashCode.getAndAdd(HASH_INCREMENT);
    }

    public static void main(String[] args) {
        System.out.println(0x61c88647);
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < 200; i++) {
            int i1 = new TestKey().threadLocalHashCode;
            System.out.println(new TestKey().threadLocalHashCode);
            //System.out.println(new TestKey().threadLocalHashCode & 31);
            set.add(i1);
        }

        System.out.println(set.size());
    }


}
