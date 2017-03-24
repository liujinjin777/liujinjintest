package com.liujinjin.suanfa.common.test;

import com.liujinjin.suanfa.common.MyArrayStack;

/**
 * Created by liuxin on 17/2/14.
 */
public class TestMyArrayStack {

    public static void main(String[] args) {
        MyArrayStack myArrayStack = new MyArrayStack();
        for(int i=0; i<10; i++){
            myArrayStack.push(i);
        }

        for(int i=0; i<20; i++){
            System.out.println(myArrayStack.pop());
        }

    }
}
