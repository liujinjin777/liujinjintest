package com.liujinjin.suanfa.common;

/**
 * Created by liuxin on 17/1/19.
 */
public class Node {
    public int value;
    public Node next;

    public Node(int value ,Node nextNode) {
        this.value = value;
        this.next = nextNode;
    }

    public Node(int value) {
        this.value = value;
    }

    public Node(){}

    @Override
    protected void finalize() throws Throwable {
        System.out.println(this.value + "节点【销毁】");
        super.finalize();
    }

    @Override
    public String toString() {
        return value + "==> " + next;
    }
}
