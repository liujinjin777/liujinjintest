package com.liujinjin.suanfa190622;

import org.junit.Test;

/**
 * 24，链表交换
 * 1 -> 2 -> 3 -> 4
 * 思路：从第一个开始交换，1和2交换，3和4交换
 * 1，交换时机，可以是遍历次数为奇数
 * 2，注意中间节点交换时。 2->1->3->4  注意1->4
 *
 * @author liuxin
 * @date 2019/6/23
 */
public class T24SwapPairs {

    @Test
    public void test(){
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
        ListNode resp = this.swapPairs(listNode);
        System.out.println(resp);
    }

    public ListNode swapPairs(ListNode head) {
        int i = 0;
        ListNode resp = head;
        ListNode preNode = null;
        ListNode currentNode = head;
        while(currentNode != null && currentNode.next != null){
            // 偶数换，当前1，和2换
            if(i%2 == 0){
                // nextNode = 2
                ListNode nextNode = currentNode.next;
                // 1 -> 3
                currentNode.next = currentNode.next.next;
                // 2 -> 1
                nextNode.next = currentNode;
                currentNode = nextNode;
                if(preNode != null){
                    preNode.next = currentNode;
                } else {
                    resp = currentNode;
                }
            }

            preNode = currentNode;
            currentNode = currentNode.next;
            i++;
        }

        return resp;
    }
}
