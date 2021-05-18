package com.liujinjin.suanfa20210506.base;

/**
 * @author liuxin14 <liuxin14@kuaishou.com>
 * Created on 2021-05-07
 */
public class Node {
    public int val;
    public Node next;
    public Node random;

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }

    public Node(int val) {

    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{val=" + val + ", next=" + next + '}';
    }
}
