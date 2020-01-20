package com.liujinjin.suanfa190622;

import org.junit.Test;

/**
 * 1 -> 2 -> 3 -> 4 -> null
 *
 *
 * @author liuxin
 * @date 2019/7/1
 */
public class T206LinkedReverse {

    @Test
    public void test(){
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        System.out.println(this.reverse(listNode));
    }

    private ListNode reverse(ListNode listNode) {
        if(listNode == null){
            return null;
        }

        if(listNode.next == null){
            return listNode;
        }

        ListNode curNode = listNode;
        ListNode preNode = null;
        while(curNode != null){
            ListNode nextNode = curNode.next;
            if(preNode == null){
                curNode.next = null;
            } else {
                curNode.next = preNode;
            }
            preNode = curNode;
            curNode = nextNode;
        }

        return preNode;
    }
}
