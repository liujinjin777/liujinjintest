package com.liujinjin.suanfa.lianbiao;

/**
 * Created by liuxin on 17/1/19.
 */
public class Node {
    Object value;
    Node next;

    public Node(Object value ,Node nextNode) {
        this.value = value;
        this.next = nextNode;
    }

    public Node(Object value) {
        this.value = value;
    }

    public Node(){}


    @Override
    public String toString() {
        return value + "==> " + next;
    }
}
