package com.liujinjin.suanfa191229;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author liuxin23
 * @date 2019/12/29
 */
public class T6 {

    @Test
    public void test(){
        int[] array = {6501,6828,6963,7036,7422,7674,8146,8468,8704,8717,
                9170,9359,9719,9895,9896,9913,9962,154,293,334,492,1323,
                1479,1539,1727,1870,1943,2383,2392,2996,3282,3812,3903,
                4465,4605,4665,4772,4828,5142,5437,5448,5668,5706,5725,6300,6335};
        int i = this.minNumberInRotateArray(array);
        System.out.println(i);
    }

    public int minNumberInRotateArray(int [] array) {
        if(array == null || array.length == 0){
            return 0;
        }

        int left = 0;
        int right = array.length - 1;
        if(array[0] < array[right]){
            return array[0];
        }

        return this.recursion(array, left, right);
    }

    public int recursion(int [] array, int left, int right) {
        if(right - left  == 1){
            return min(array[left], array[right]);
        }

        while(right - left > 1){
            int mid = left + (right - left)/2;
            if(array[mid] < array[left]){
                return recursion(array, left, mid);
            }

            if(array[mid] > array[right]){
                return recursion(array, mid, right);
            }
        }
        return 0;
    }

    public static int min(int a, int b) {
        return (a <= b) ? a : b;
    }
}
