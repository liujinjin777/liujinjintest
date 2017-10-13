package com.liujinjin.book.javaer.t6;

/**
 * Created by liuxin on 2017/8/21.
 */
public class Client {

    static class Base{
        void fun(int price, int... discount){
            System.out.println("base ... fun");
        }
    }

    static class Sub extends Base{
        @Override
        void fun(int price, int[] discount){
            System.out.println("sub ... fun");
        }
    }

    public static void main(String[] args) {
        Base base = new Sub();
        base.fun(1, 1);

        int[] a = {1, 2};
        Sub sub = new Sub();
        sub.fun(1, a);
    }
}
