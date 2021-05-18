package com.liujinjin.suanfa20210506.node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test;

/**
 * @author liuxin14 <liuxin14@kuaishou.com>
 * Created on 2021-05-09
 */
public class T15 {

    @Test
    public void test() {
        HashMap<String, String> map = new HashMap<>();
        map.put(null, null);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        // 排序 -4 -1 -1 0  1 2
        Arrays.sort(nums);

        int left = 1;
        int right = nums.length - 1;
        List<List<Integer>> list = new ArrayList<>();
        int pre = 0;
        // 双指针遍历，i i+1 length
        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == pre) {
                continue;
            }
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    List<Integer> oneList = new ArrayList<>();
                    oneList.add(nums[i]);
                    oneList.add(nums[left]);
                    oneList.add(nums[right]);
                    list.add(oneList);
                    // 找到不同的右节点值
                    int rVal = nums[right];
                    right--;
                    while (rVal == nums[right] && left <= right) {
                        right--;
                    }
                    // 左
                    int lVal = nums[left];
                    left++;
                    while (rVal == nums[left] && left <= right) {
                        left++;
                    }
                }
            }
            right = nums.length - 1;
            left = i + 2;
            pre = nums[i];
        }


        return list;
    }
}
