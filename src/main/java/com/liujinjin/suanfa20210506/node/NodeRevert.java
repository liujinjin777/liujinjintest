package com.liujinjin.suanfa20210506.node;

import com.liujinjin.suanfa20210506.base.Node;

/**
 * 单链表翻转
 * @author liuxin14 <liuxin14@kuaishou.com>
 * Created on 2021-05-01
 */
public class NodeRevert {

    public static void main(String[] args) {
        Node node = new Node(1, null);
        System.out.println(node);
        System.out.println(revert(node));
    }

    public static Node revert(Node node) {
        if (node == null || node.next == null) {
            return node;
        }

        // 1 -> 2 -> 3 -> 4
        // 2 -> 1 -> 3 -> 4
        // 头结点
        Node head = node;
        // next节点
        Node next;
        while ((next = node.next) != null) {
            // 1 -> 3   1 -> 4
            node.next = next.next;
            // 2 -> 1   3 -> 2
            next.next = head;
            // head = 2、3
            head = next;
        }
        return head;
    }
}
