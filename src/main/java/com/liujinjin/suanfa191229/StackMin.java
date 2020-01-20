package com.liujinjin.suanfa191229;

import java.util.Stack;

/**
 * @author liuxin23
 * @date 2020/01/09
 */
public class StackMin {

    Stack<Integer> stack1 = new Stack();
    Stack<Integer> stack2 = new Stack();
    public void push(int node) {
        stack1.push(node);
        if(stack2.isEmpty()){
            stack2.push(node);
        }else if(stack2.peek() >= node){
            stack2.push(node);
        }
    }
    public void pop() {
        int pop1 = stack1.pop();
        if(pop1 == stack2.peek()){
            stack2.pop();
        }

    }
    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }
}
