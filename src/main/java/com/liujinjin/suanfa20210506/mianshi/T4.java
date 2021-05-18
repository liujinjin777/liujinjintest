package com.liujinjin.suanfa20210506.mianshi;

import org.junit.Test;

import com.liujinjin.suanfa20210506.base.ListNode;

/**
 * 返回链表指定位置
 *
 * @author liuxin14 <liuxin14@kuaishou.com>
 * Created on 2021-05-09
 */
public class T4 {

    @Test
    public void test() {
        ListNode n1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        System.out.println(revert(n1, 1, 4));
    }

    public ListNode revert(ListNode head, int start, int end) {
        if (head == null) {
            return null;
        }

        ListNode cur = head;
        ListNode pre = null;
        ListNode revertHead = null;
        ListNode revertPre = null;
        // 1 -> 2 -> 3 -> 4 -> 5
        // 2 4
        while (cur != null) {
            if (start <= 0 && end <= 0) {
                break;
            }
            // -2 0
            start--;
            end--;
            if (start <= 0) {
                if (revertHead == null) {
                    // 2
                    revertHead = cur;
                    // 2
                    revertPre = cur;
                    // 3
                    cur = cur.next;
                } else { // 1 3 2 4 5
                    // 2 -> 5
                    revertPre.next = cur.next;
                    // 4 -> 3
                    cur.next = revertHead;
                    // revertHead=4
                    revertHead = cur;
                    // cur=5
                    cur = revertPre.next;
                }
            } else {
                // 1
                pre = cur;
                // 2
                cur = cur.next;
            }
        }

        // 将翻转后的头结点衔接上
        if (pre != null) {
            pre.next = revertHead;
        } else {
            head = revertHead;
        }
        return head;
    }
}