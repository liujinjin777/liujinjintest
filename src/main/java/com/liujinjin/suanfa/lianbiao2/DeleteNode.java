package com.liujinjin.suanfa.lianbiao2;

import com.liujinjin.suanfa.common.Node;

/**
 * 题2：给定一个单链表的头指针和一个指定节点的指针，在O(1)时间删除该节点
 * <p>
 * <p>
 * Created by liuxin on 17/1/20.
 */
public class DeleteNode {

    public static Node deleteNode(Node nodeHead, Node deleteNode) {
        if (deleteNode == null) return nodeHead;
        if (nodeHead == null) return null;

        Node node = nodeHead;
        Node preNode = null;
        while(node != null){
            if(node == deleteNode){
                if(node == nodeHead) {
                    nodeHead = nodeHead.next;
                } else if (node.next == null) {
                    preNode.next = null;
                }else {
                    preNode.next = node.next;
                }
                break;
            }

            preNode = node;
            node = node.next;
        }

        return nodeHead;
    }

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
        System.out.println(DeleteNode.deleteNode(node1, node5));
    }


}
