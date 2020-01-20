package com.liujinjin.book.codingInterviews.t5;

import com.liujinjin.suanfa.common.Node;
import com.liujinjin.suanfa.common.NodeUtil;

import java.util.Arrays;

/**
 * Created by liuxin on 17/2/13.
 */
public class RevertPrintNode {

    public static void main(String[] args) {
        Node nodeList = NodeUtil.getNodeList();
        System.out.println(nodeList);

        revertPrintNode2(nodeList);

    }

    // 更改原链表
    public static void revertPrintNode(Node head){
        if(head == null) return;

        Node newHead = null;

        while(head != null){
            Node temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }

        while(newHead != null){
            System.out.println(newHead.value);
            newHead = newHead.next;
        }
    }

    // 不更改原链表
    public static void revertPrintNode2(Node head){
        if(head == null) return;

        int length = 0;
        Node headTemp = head;
        while(headTemp != null){
            headTemp = headTemp.next;
            length++;
        }

        int[] array = new int[length];
        while(head != null){
            array[length-1] = head.value;
            head = head.next;
            length--;
        }

        System.out.println(Arrays.toString(array));

    }

}
