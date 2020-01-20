package com.liujinjin.suanfa190622;

import org.junit.Test;

/**
 * @author liuxin
 * @date 2019/7/3
 */
public class T42Trap {

    @Test
    public void test(){
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] maxRig = {0,3,3,3,3,3,3,3,2,2,1,0};
        System.out.println(this.trap(height));
    }

    public int trap(int[] height) {
        if(height == null || height.length < 3){
            return 0;
        }

        int sum = 0;
        int maxLeft = height[0];
        int[] maxRightArray = new int[height.length];
        for (int i = height.length -2 ; i > 0 ; i--) {
            maxRightArray[i] = Math.max(maxRightArray[i+1], height[i+1]);
        }


        for (int i = 1; i < height.length-1 ; i++){
            // 找左面最大
            maxLeft = Math.max(maxLeft, height[i - 1]);

            // 找右面最大
            int maxRight = maxRightArray[i-1];

            int min = Math.min(maxLeft, maxRight);
            if(min > height[i]){
                sum = sum + min - height[i];
            }
        }

        return sum;
    }



}
