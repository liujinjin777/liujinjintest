package com.liujinjin.suanfa.lianbiao2;

import com.liujinjin.suanfa.common.Node;

/**
 * 题3：假设有两个单链表A和B，不带头节点，且长度一样，示例如下：
 * A: 1->2->3->4
 * B: a->b->c->d
 * 请逆转交替合并两个链表
 * 4->d->3->c->2->b->1->a
 *
 * Created by liuxin on 17/1/20.
 */
public class Merge2Node {

    public Node merge(Node nodeA, Node nodeB){
        if(nodeA == null) return nodeB;
        if(nodeB == null) return null;

        Node head = nodeA;
        Node nodeBPoint = nodeB;
        boolean flag = true;

        while(nodeA != null){
            if(flag) {
                Node nextNodeA = nodeA.next;
                nodeA.next = nodeB;

                nodeBPoint = nodeBPoint.next;
                nodeB.next = nextNodeA;

                flag = false;
            }else {
                flag = true;
            }

            nodeA = nodeA.next;
        }

        return nodeA;
    }


}
