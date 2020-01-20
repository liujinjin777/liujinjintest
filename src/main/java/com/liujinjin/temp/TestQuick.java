package com.liujinjin.temp;

import java.util.Arrays;

/**
 * Created by liuxin on 2017/9/23.
 */
public class TestQuick {

    public static void main(String[] args) {
        int[] array = {8, 7, 6, 5, 4, 3, 1, 2};

        System.out.println(Arrays.toString(array));
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] array){
        if(array == null || array.length == 1){
            return;
        }
        sort(array, 0, array.length-1);
    }

    private static void sort(int[] array, int start, int end) {
        if(start == end) return;

        int left = start;
        
        int right = end;
        int point = array[start];


        while(left < right){

            while(left < right && array[right] >= point){
                right--;
            }

            if(left < right){
                array[left] = array[right];
                left++;
            }

            while(left < right && array[left] <= point){
                left++;
            }
            if(left < right){
                array[right] = array[left];
                right--;
            }
        }

        array[left] = point;
        if(left - 1 > start){
            sort(array, start, left-1);
        }
        if(right + 1 < end){
            sort(array, right+1, end);
        }
    }
}







