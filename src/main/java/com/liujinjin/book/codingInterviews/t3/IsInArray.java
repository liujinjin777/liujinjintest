package com.liujinjin.book.codingInterviews.t3;

import java.util.Arrays;

/**
 * 3、在一个二维数组中，行按照从左到右递增顺序，列从上到下递增。输入一个数，是否在二维数组中。
 *
 *  1 2 8  9
 *  2 4 9  12
 *  4 7 10 13
 *  6 8 11 15
 *
 * Created by liuxin on 17/2/13.
 */
public class IsInArray {

    public static void main(String[] args) {
        int[][] array2w = new int[][]{{1,2,8,9}, {2,4,9,12}, {4,7,10,13}, {6,8,11,15}};
        System.out.println(Arrays.deepToString(array2w));
        System.out.println(IsInArray.isInArray(array2w, 2));
    }

    public static boolean isInArray(int[][] array2w, int a){
        if(array2w == null) return false;

        int row = 0;
        int column = array2w[0].length-1;

        while(row >= 0 && row < array2w.length && column >= 0) {
            if (array2w[row][column] < a) {
                row++;
            } else if (array2w[row][column] > a) {
                column--;
            } else if (array2w[row][column] == a) {
                return true;
            }
        }

        return false;
    }
}
