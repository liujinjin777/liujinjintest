package com.liujinjin.suanfa190622;

import org.apache.commons.lang.ArrayUtils;
import org.junit.Test;

/**
 * @author liuxin
 * @date 2019/6/23
 */
public class T {

    @Test
    public void test(){
        int[] array = {4,5};
        int i = this.removeElement(array, 5);
        System.out.println(i);
        System.out.println(ArrayUtils.toString(array));
    }

    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        if(nums.length == 1){
            if(nums[0] == val){
                return 0;
            }
            return 1;
        }

        int i = 0;
        int j = nums.length - 1;

        while(i < j){
            if(nums[j] == val){
                j--;
                continue;
            }
            if(nums[i] != val){
                i++;
                continue;
            }

            swap(nums, i, j);
        }
        String s = "1";
        s.toCharArray();
        s.length();
        if(i ==0 && j == 0){
            if(i == nums.length - 1){
                return nums.length;
            }
            return 0;
        }


        return i+1;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
