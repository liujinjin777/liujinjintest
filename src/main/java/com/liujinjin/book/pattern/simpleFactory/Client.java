package com.liujinjin.book.pattern.simpleFactory;

/**
 * @author liuxin
 * @date 2018/5/4
 */
public class Client {

    public static void main(String[] args) {
        Son1 son1 = Factory.create(Son1.class);
        System.out.println(son1);
    }
}
