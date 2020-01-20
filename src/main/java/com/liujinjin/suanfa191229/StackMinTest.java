package com.liujinjin.suanfa191229;

import java.util.Stack;

/**
 * @author liuxin23
 * @date 2020/01/09
 */
public class StackMinTest {

    public static void main(String[] args) {
        StackMin stack = new StackMin();
        stack.push(4);   // 4
        stack.push(4);   // 4
        stack.push(3);   // 3
        stack.push(1);   // 1
        stack.push(4);   // 1
        stack.push(2);   // 1

        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
    }
}
