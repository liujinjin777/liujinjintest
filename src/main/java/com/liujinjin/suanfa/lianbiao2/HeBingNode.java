package com.liujinjin.suanfa.lianbiao2;

import com.liujinjin.suanfa.common.Node;

/**
 * Created by liuxin on 17/1/20.
 */
public class HeBingNode {

    public static Node hebingNode(Node nodeA, Node nodeB){
        if(nodeA == null ) return nodeB;
        if(nodeB == null ) return null;

        Node nodeMaxHead = null;
        Node nodeMinHead = null;

        // 区分大小头结点
        if(Integer.valueOf(nodeA.value.toString()) > Integer.valueOf(String.valueOf(nodeB.value))){
            nodeMaxHead = nodeA;
            nodeMinHead = nodeB;
        }else {
            nodeMaxHead = nodeB;
            nodeMinHead = nodeA;
        }

        // 记录遍历节点前一个节点
        Node preNode = null;
        Node node = nodeMinHead;

        while(nodeMinHead != null && nodeMaxHead != null){
            // 插入节点
            if(Integer.valueOf(String.valueOf(nodeMinHead.value)) > Integer.valueOf(String.valueOf(nodeMaxHead.value))){
                Node tempNode = nodeMaxHead;
                nodeMaxHead = nodeMaxHead.next;

                preNode.next = tempNode;
                tempNode.next = nodeMinHead;
            }

            preNode = nodeMinHead;
            nodeMinHead = nodeMinHead.next;
        }

        // 当大头结点链表未遍历完
        if(nodeMaxHead != null){
            preNode.next = nodeMaxHead;
        }

        return node;
    }

    public static void main(String[] args) {
        Node node1 = new Node(2, new Node(4, new Node(8, null)));
        Node node2 = new Node(2, new Node(3, new Node(5, new Node(9, new Node(10, null)))));

        System.out.println(HeBingNode.hebingNode(node1, node2));
    }

}
