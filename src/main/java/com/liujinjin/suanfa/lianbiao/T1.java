package com.liujinjin.suanfa.lianbiao;

import com.liujinjin.suanfa.common.Node;

/**
 * 链表倒置方法
 *
 * Created by liuxin on 17/1/19.
 */
public class T1 {

    /**
     *  1-->2-->3-->4-->5
     *  2-->1-->3-->4-->5
     *  3-->2-->1-->4-->5
     *  ....
     *  5-->4-->3-->2-->1
     */
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

    /**
     * 1-->2-->3-->4-->5
     *
     * 1-->null
     * 2-->1
     * 3-->2-->1
     * ....
     * 5-->4-->3-->2-->1
     */
    public Node reverNode2(Node node){
        if(node == null) return null;

        Node headNode = null; // null

        while(node != null){
            // 保存node的next节点, 因为下一行代码导致next节点改变
            Node temp = node.next;

            // 将当前节点放在头节点之前 1-->null    2-->1-->null
            node.next = headNode;
            headNode = node;

            // 向后循环节点
            node = temp;
        }

        return headNode;
    }




}











