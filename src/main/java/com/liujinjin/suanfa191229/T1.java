package com.liujinjin.suanfa191229;

/**
 *
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @author liuxin23
 * @date 2019/12/29
 */
public class T1 {

    public boolean find(int target, int[][] array) {
        if (array == null) {
            return false;
        }

        int row = array.length;
        int pow = array[0].length;
        int j = 0;
        for (int i=row-1; i>=0 ;i--){
            if(target > array[i][j]){
                i++;
                j++;
                if(j == pow){
                    break;
                }
            } else if (target < array[i][j]){
                continue;
            } else {
                return true;
            }
        }

        return false;
    }
}
