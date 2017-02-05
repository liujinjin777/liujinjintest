package com.liujinjin.suanfa.swap;

/**
 * Created by liuxin on 17/2/4.
 *
 * 测试交换效率
 */
public class T1 {

    public static void main(String[] args) {
        T1 t1 = new T1();

        int a = 1;
        int b = 2;

        long currentTime = System.currentTimeMillis();
        for(int i = 0; i < 10000000; i++){
            t1.swap3(a, b);
        }
        System.out.println((System.currentTimeMillis() - currentTime) + "ms");

    }

    public void swap(int a, int b){
        int temp = a;
        a = b;
        b = temp;
        System.out.println("a=" + a +" b=" + b);
    }

    public void swap2(int a, int b){
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("a=" + a +" b=" + b);
    }

    public void swap3(int a, int b){
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a=" + a +" b=" + b);
    }

}
