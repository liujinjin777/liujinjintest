package com.liujinjin.suanfa.common;

/**
 * Created by liuxin on 17/2/13.
 */
public class BinaryTree {

    public int value;
    public BinaryTree leftChildNode;
    public BinaryTree rightChildNode;

    public BinaryTree(){}

    public BinaryTree(int value, BinaryTree leftChildNode, BinaryTree rightChildNode){
        this.value = value;
        this.leftChildNode = leftChildNode;
        this.rightChildNode = rightChildNode;
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "value=" + value +
                ", leftChildNode=" + leftChildNode +
                ", rightChildNode=" + rightChildNode +
                '}';
    }
}
