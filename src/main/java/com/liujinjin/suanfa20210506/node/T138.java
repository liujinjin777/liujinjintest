package com.liujinjin.suanfa20210506.node;

import org.junit.Test;

/**
 * @author liuxin14 <liuxin14@kuaishou.com>
 * Created on 2021-05-09
 */
public class T138 {

    @Test
    public void test() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;

        n1.random = n3;
        n2.random = n3;
        n3.random = n4;
        n4.random = n2;
        n5.random = n1;

        System.out.println(copyRandomList(n1));
        System.out.println(n1);
    }

    public Node copyRandomList(Node head) {
        // 在原有列表中复制一份
        // 例如 1-》2 -》3-》4  变为  1-》1-》2-》2-》3-》3-》4-》4
        if (head == null) {
            return null;
        }

        Node cur = head;
        Node pre = null;
        // 1-》1-》2-》2-》3-》3-》4-》4
        while (cur != null) {
            Node copy = new Node(cur.val);
            // 2
            Node next = cur.next;
            // 1->1
            cur.next = copy;
            // 1->2
            copy.next = next;
            copy.random = cur.random;
            // 循环赋值
            pre = copy;
            cur = next;
        }

        // 赋值random节点
        cur = head;
        while (cur != null && cur.next != null) {
            // 赋值copy节点的random
            Node random = cur.next.random;
            if (random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        // 拆分链表
        // copy 1
        cur = head;
        // c1
        Node copyHead = cur.next;
        // 1-》1-》2-》2-》3-》3-》4-》4
        while (cur != null && cur.next != null) {
            Node copy = cur.next;
            // 原1->2
            cur.next = cur.next.next;
            // 新
            if (copy.next != null) {
                copy.next = copy.next.next;
            }
        }

        return copyHead;
    }
    class Node {
        @SuppressWarnings("checkstyle:VisibilityModifier")
        int val;
        @SuppressWarnings("checkstyle:VisibilityModifier")
        Node next;
        @SuppressWarnings("checkstyle:VisibilityModifier")
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        @Override
        public String toString() {
            return "val=" + val + ", (next=" + next + "), (random=" + random.val + ")";
        }
    }
}
