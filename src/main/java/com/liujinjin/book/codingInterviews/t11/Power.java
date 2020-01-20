package com.liujinjin.book.codingInterviews.t11;

/**
 * Created by liuxin on 17/2/15.
 */
public class Power {

    public static void main(String[] args) {
        double base = 0;
        int exponent = 9;
        System.out.println(pow(base, exponent));
    }

    public static double pow(double base, int exponent){
        double resp = 1;
        for(int i =1; i<=exponent; i++){
            resp *= base;
        }

        return resp;
    }
}
