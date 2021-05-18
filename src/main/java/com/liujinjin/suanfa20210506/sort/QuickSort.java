package com.liujinjin.suanfa20210506.sort;

import java.util.Arrays;

import org.junit.Test;

/**
 * 快排
 * @author liuxin14 <liuxin14@kuaishou.com>
 * Created on 2021-05-05
 */
public class QuickSort {

    @Test
    public void test() {
        int[] array = {3, 4, 5, 2, 1};
        // 以3为中间点，把小于3的放在左面，大于3的放在3的右边
        // 再递归排序3左面，3右面
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }

    private void quickSort(int[] array) {
        if (array == null || array.length == 0 || array.length == 1) {
            return;
        }
        quickSortInner(array, 0, array.length - 1);
    }

    private void quickSortInner(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }

        int left = start;
        int right = end;
        int midTemp = left; // 中位数的所在茭白哦
        int midVal = array[midTemp];

        // 3, 4, 5, 2, 1
        while (left < right) {
            // 从右边遍历，找到第一个比中位数小的
            while (array[right] > midVal && left < right) {
                right--;
            }
            if (left < right) {
                // 1, 4, 5, 2, 1(3)
                array[midTemp] = array[right];
                midTemp = right;
                left++;
            }
            if (left >= right) {
                break;
            }

            // 从左边遍历
            while (array[left] < midVal && left < right) {
                left++;
            }
            if (left < right) {
                // 1, 4(3), 5, 2, 4
                array[midTemp] = array[left];
                midTemp = left;
                right--;
            }
            if (left >= right) {
                break;
            }
            array[midTemp] = midVal;
        }
        array[midTemp] = midVal;

        quickSortInner(array, start, left - 1);
        quickSortInner(array, left + 1, end);
    }
}
