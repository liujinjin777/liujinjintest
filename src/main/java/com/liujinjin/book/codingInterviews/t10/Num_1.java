package com.liujinjin.book.codingInterviews.t10;

/**
 * 题目：请实现一个函数，输入一个整数，输出该数二进制表示1的个数。
 * 例如：把9表示为二进制1001，有2位1。因此如果输入9，该函数输出2。
 *
 * Created by liuxin on 17/2/15.
 */
public class Num_1 {

    public static void main(String[] args) {
        int i = -1;
        System.out.println(get1Num2(i));
    }

    public static int get1Num(int num){
        int i = 0;
        int flag = 1;
        while(flag != 0){
            if((num & flag) != 0)
                i++;
            flag = flag << 1;
        }
        return i;
    }

    /**
     * 1001
     *
     * (1001-1) & 1001
     *
     * 1000
     * 1001 = 1000
     *
     * 每次减1与原数, 就会消除掉一个1.
     */
    public static int get1Num2(int num){
        int i = 0;
        while(num != 0){
            num = num & (num -1);
            i++;
        }
        return i;
    }


}
