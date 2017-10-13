package com.liujinjin.temp;

import com.liujinjin.suanfa.common.Node;

/**
 * Created by liuxin on 2017/9/23.
 *
 * 1 -> 2 -> 3 - 4
 */
public class T12 {


    public static void main(String[] args) {
        Node node = new Node(1,
                        new Node(2,
                                new Node(3,
                                        new Node(4,
                                                new Node(5)))));
        System.out.println(node);
        Node nodeResp = new T12().reverseNode(node);
        System.out.println(nodeResp);


    }

    public Node reverseNode(Node node){
        if(node == null || node.next  == null)
            return node;

        Node headNode = node;
        Node currentNode =node.next;
        Node preNode = node;

        while(currentNode != null){
            Node next = currentNode.next;
            currentNode.next = headNode;
            preNode.next = next;

            headNode = currentNode;
            currentNode = preNode.next;
        }

        return headNode;
    }

}











