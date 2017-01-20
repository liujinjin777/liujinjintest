package com.liujinjin.suanfa.lianbiao;

/**
 * Created by liuxin on 17/1/19.
 */
public class T1 {

    public Node reverNode(Node node){
        if(node == null) return null;

        Node headNode = node;
        Node preHeadNode = node;
        Node currentNode = node.next;

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
