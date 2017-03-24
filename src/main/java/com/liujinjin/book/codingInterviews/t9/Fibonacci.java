package com.liujinjin.book.codingInterviews.t9;

/**
 * Created by liuxin on 17/2/15.
 */
public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(fibonacci(4));
    }

    public static int fibonacci(int n){
        if(n == 0) return 0;
        if(n == 1) return 1;

        int fibonacciOne = 0;
        int fibonacciTwo = 1;
        int resp = 0;

        for(int i = 2; i <= n - 1; i++){
            resp = fibonacciOne + fibonacciTwo;
            fibonacciOne = fibonacciTwo;
            fibonacciTwo = resp;
        }

        return resp;
    }


}
