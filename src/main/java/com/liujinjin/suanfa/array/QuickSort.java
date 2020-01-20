package com.liujinjin.suanfa.array;

import java.util.Arrays;

/**
 * Created by liuxin on 17/2/16.
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] a = {8,8,8,8,3,1,2,5,2};
        quickSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void quickSort(int[] array){
        if(array == null || array.length == 0)
            throw new RuntimeException("array is null");
        sort(array, 0, array.length - 1);
    }

    private static void sort(int[] array, int start, int end){
        int povit = array[start];
        int left = start;
        int right = end;

        while(left < right){
            while(left < right && array[right] >= povit){
                right--;
            }
            // 右边数大于基数，赋值到left位置。这里应该是交换，使
            // 用技巧，最后进行赋值。
            if(left < right){
                array[left] = array[right];
                left++;
            }

            while(left < right && array[left] <= povit){
                left++;
            }
            if(left < right){
                array[right] = array[left];
                right--;
            }
        }
        // 在这里进行赋值，否则数组中会有两个一样数值
        array[left] = povit;
        if(start < left - 1){
            sort(array, start, left - 1);
        }
        if(left + 1 < end){
            sort(array, left + 1, end);
        }
    }


}
