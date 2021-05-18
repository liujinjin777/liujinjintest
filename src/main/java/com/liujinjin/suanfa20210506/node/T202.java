package com.liujinjin.suanfa20210506.node;

import org.junit.Test;

/**
 * @author liuxin14 <liuxin14@kuaishou.com>
 * Created on 2021-05-10
 */
public class T202 {

    @Test
    public void test() {
        System.out.println(isHappy(3));
    }

    public boolean isHappy(int n) {
        int cur = calTotal(n);
        int nextNext = calTotal(calTotal(n));
        while (cur != 1) {
            if (cur == nextNext) {
                return false;
            }
            cur = calTotal(cur);
            nextNext = calTotal(calTotal(nextNext));
        }

        return true;
    }

    public int calTotal(int x) {
        int total = 0;
        do {
            // 余数
            int y = x % 10;
            total += y * y;
            // 除数
            x = x / 10;
        } while (x != 0);
        return total;
    }
}
