package com.liujinjin.suanfa190127;

import org.junit.Test;

/**
 * @author liuxin
 * @date 2019/1/27
 */
public class SubSum {

    @Test
    public void main() {
        int[] nums = {-4, -3, -2};
        System.out.println(this.maxProduct2(nums));
    }


    public int maxProduct(int[] nums) {
        // write your code here
        int posmax = nums[0], negmax = nums[0], max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int tempPosMax = posmax;
            int tempNegMax = negmax;
            posmax = Math.max(nums[i], Math.max(nums[i] * tempPosMax, nums[i] * tempNegMax));
            negmax = Math.min(nums[i], Math.min(nums[i] * tempPosMax, nums[i] * tempNegMax));
            if (Math.max(posmax, negmax) > max) {
                max = Math.max(posmax, negmax);
            }
        }

        return max;

    }

    public int maxProduct2(int[] num) {
        // write your code here
        if (num == null) {
            return 0;
        }

        int subMax = num[0];
        int subMin = num[0];
        int max = num[0];
        for (int i = 1; i < num.length; i++) {
            int tempSubMax = subMax;
            int tempSubMin = subMin;
            subMax = this.max(num[i], this.max(num[i] * tempSubMax, num[i] * tempSubMin));
            subMin = this.min(num[i], this.min(num[i] * tempSubMax, num[i] * tempSubMin));

            if(this.max(subMax, subMin) > max){
                max = this.max(subMax, subMin);
            }
        }
        return max;

    }


    private int min(int x, int y) {
        if (x <= y) {
            return x;
        }
        return y;
    }

    private int max(int x, int y) {
        if (x >= y) {
            return x;
        }
        return y;
    }
}
