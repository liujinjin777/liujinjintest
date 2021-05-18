package com.liujinjin.suanfa20210506.mianshi;

import org.junit.Test;

/**
 * @author liuxin14 <liuxin14@kuaishou.com>
 * Created on 2021-05-16
 */
public class T138 {

    @Test
    public void test() {
        int[] array = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(7, array));

    }

    public int minSubArrayLen(int target, int[] nums) {
        int min = nums.length + 1;
        int left = 0;
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            if (sum == target) {
                min = Math.min(i - left + 1, min);
            } else if (sum > target) {
                sum -= nums[left];
                left++;
            }
            if (min == 1) {
                return 1;
            }
        }

        return min == nums.length + 1 ? 0 : min;
    }
}
