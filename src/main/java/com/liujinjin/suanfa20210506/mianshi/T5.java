package com.liujinjin.suanfa20210506.mianshi;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

import org.junit.Test;

/**
 * @author liuxin14 <liuxin14@kuaishou.com>
 * Created on 2021-05-10
 */
public class T5 {

    @Test
    public void test() {

        Deque<Integer> stack = new ArrayDeque<Integer>();
        stack.removeLast();

        List<int[]> list = new ArrayList<>();
        list.toArray();

        int[] nums = {1, 2, 3, 4, 5};
        rotate(nums, 2);
        System.out.println(Arrays.toString(nums));
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int count = k - 1;
        for (int start = 0; start < count; ++start) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
            } while (start != current);
        }
    }

    public int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }

}
