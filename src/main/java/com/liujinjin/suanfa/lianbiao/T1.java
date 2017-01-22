package com.liujinjin.suanfa.lianbiao;

import com.liujinjin.suanfa.common.Node;

/**
 * Created by liuxin on 17/1/19.
 */
public class T1 {

    public Node reverNode(Node node){
        if(node == null) return null;

        Node headNode = node;           // 头结点
        Node preHeadNode = node;        // 当前结点前结点
        Node currentNode = node.next;   // 当前结点

        while(currentNode != null){
            // 删除
            preHeadNode.next = currentNode.next;
            currentNode.next = headNode;
            // 重置值
            headNode = currentNode;
            currentNode = preHeadNode.next;
        }


        return headNode;
    }
}
