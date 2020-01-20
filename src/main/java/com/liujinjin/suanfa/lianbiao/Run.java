package com.liujinjin.suanfa.lianbiao;

import com.liujinjin.suanfa.common.Node;

/**
 * Created by liuxin on 17/1/19.
 */
public class Run {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;


        System.out.println(node1);
        //System.out.println(new T1().reverNode(node));
        System.out.println(new T1().reverNode2(node1));
        System.out.println(node1);

    }
}
