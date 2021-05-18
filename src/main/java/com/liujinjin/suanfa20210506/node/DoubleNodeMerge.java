package com.liujinjin.suanfa20210506.node;

import org.junit.Test;

import com.liujinjin.suanfa20210506.base.Node;

/**
 * 双链表合并
 * 1 -> 3 -> 5
 * 2 -> 4 -> 6
 *
 * @author liuxin14 <liuxin14@kuaishou.com>
 * Created on 2021-05-06
 */
public class DoubleNodeMerge {

    @Test
    public void test() {
        Node n1 = new Node(1, new Node(3, new Node(5, null)));
        Node n2 = new Node(2, new Node(4, new Node(6, null)));
        System.out.println(merge(n1, n2));
    }

    private Node merge(Node n1, Node n2) {
        if (n1 == null) {
            return n2;
        }
        if (n2 == null) {
            return n1;
        }

        return null;
    }

}
