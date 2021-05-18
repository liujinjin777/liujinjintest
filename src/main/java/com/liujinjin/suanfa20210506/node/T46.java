package com.liujinjin.suanfa20210506.node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import org.junit.Test;

/**
 * @author liuxin14 <liuxin14@kuaishou.com>
 * Created on 2021-05-13
 */
public class T46 {

    @Test
    public void test() {
        int[] a = {1, 2, 3};
        System.out.println(permute(a));
    }

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return null;
        }

        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        int length = nums.length;

        dfs(nums, res, stack, length, 0);
        return res;
    }

    /**
     * c 剩余数据个数
     */
    public void dfs(int[] nums, List<List<Integer>> res, Deque<Integer> stack, int length, int count) {
        if (length == count) {
            res.add(new ArrayList<>(stack));
            return;
        }

        for (int i = 0; i < length; i++) {
            if (stack.contains(nums[i])) {
                continue;
            }

            stack.addLast(nums[i]);
            dfs(nums, res, stack, length, count + 1);
            stack.removeLast();
        }
    }
}
