package com.liujinjin.suanfa.common;

/**
 * Created by liuxin on 17/1/23.
 */
public class NodeUtil {

    public static Node getNodeList(){
        Node node1 = new Node(1);
        Node node2 = new Node(3);
        Node node3 = new Node(6);
        Node node4 = new Node(2);
        Node node5 = new Node(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        return node1;
    }
}
