package com.liujinjin.suanfa.lianbiao2;

import com.liujinjin.suanfa.common.Node;
import com.liujinjin.suanfa.common.NodeUtil;

/**
 * 单链表排序
 * <p>
 * Created by liuxin on 17/1/22.
 */
public class SortNode {

    public static void main(String[] args) {
        Node nodeList = NodeUtil.getNodeList();
        System.out.println(new SortNode().sortNode(nodeList));
    }

    /**
     * 1 --> 3 --> 2 --> 6 --> 5
     *
     * 6
     * 6--> 5
     * 6--> 5--> 3
     *
     */
    public Node sortNode(Node node) {
        if (node == null) return null;

        Node headNode = null;   // 返回链表头结点

        while (node != null) {
            Node maxNode = node;
            Node maxPreNode = null;

            // 寻找最大数值节点
            while (node.next != null) {
                if (maxNode.value < node.next.value) {
                    maxPreNode = node;
                    maxNode = node.next;
                }
            }

            // 将当前最大节点连接在headNode后面
            if (headNode == null) {
                headNode = maxNode;
            } else {
                headNode.next = maxNode;
            }

            // 删除最大节点
            // 节点在头位置
            if (maxPreNode == null) {
                node = node.next;
            }
            // 尾位置
            else if (maxNode.next == null) {
                maxPreNode.next = null;
            }
            // 中间位置
            else {
                maxPreNode.next = maxNode.next;
            }

        }

        return headNode;
    }



}






