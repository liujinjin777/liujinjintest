package com.liujinjin.book.javaer.t40;

/**
 * Created by liuxin on 2017/8/21.
 */
public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator(1, 2) {
            {
                setOperator(1);
            }
        };
        System.out.println(calculator.getResult());

        Son son = new Son(1, 2);
        System.out.println(son.getResult());
    }
}
