package com.liujinjin.suanfa20210506.query;

import org.junit.Test;

/**
 * 二分查找
 * @author liuxin14 <liuxin14@kuaishou.com>
 * Created on 2021-05-06
 */
public class BinaryQuery {

    @Test
    public void test() {
        int[] array = {1, 3, 5, 7};
        int[] array1 = {1};
        int[] array2 = {1, 3};
        System.out.println(query(array2, 0));
        System.out.println(query(array2, 1));
        System.out.println(query(array2, 2));
        System.out.println(query(array2, 8));

    }

    private int query(int[] array, int val) {
        if (array == null) {
            return 0;
        }

        int start = 0;
        int end = array.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (val > array[mid]) {
                start = mid + 1;
            } else if (val < array[mid]) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return start;
    }
}
