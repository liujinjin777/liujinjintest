package com.liujinjin.suanfa20210506.node;

import org.junit.Test;

import com.liujinjin.suanfa20210506.base.ListNode;

/**
 * @author liuxin14 <liuxin14@kuaishou.com>
 * Created on 2021-05-08
 */
public class T25 {

    @Test
    public void test() {
        ListNode l2 = new ListNode(1, new ListNode(2, new ListNode(3,
                new ListNode(4, new ListNode(5, null)))));
        System.out.println(reverseKGroup(l2, 3));
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }

        ListNode cur = head;
        int n = k;
        ListNode revertHead = head;
        ListNode resultHead = null;
        // 翻转后的前节点
        ListNode revertBefore = null;
        while (cur != null) {
            if (n > 1) {
                n--;
                cur = cur.next;
            } else {
                // 翻转
                ListNode next = cur.next;
                ListNode temp = revert(revertHead, cur);
                if (resultHead == null) {
                    resultHead = temp;
                }
                // 设置翻转后的前节点
                if (revertBefore != null) {
                    revertBefore.next = temp;
                }
                revertBefore = revertHead;
                revertHead = next;
                cur = next;
                n = k;
            }
        }
        return resultHead;
    }

    /*
     * 翻转链表
     */
    private ListNode revert(ListNode head, ListNode end) {
        // 1 2 3
        ListNode cur = head; // 2
        ListNode resultHead = head;
        ListNode pre = null; // 1
        while (cur != null) {
            if (pre != null) {
                ListNode next = cur.next;
                pre.next = next;
                cur.next = resultHead;
                resultHead = cur;

                if (cur == end) {
                    break;
                }
                cur = next;
            } else {
                if (cur == end) {
                    break;
                }
                pre = cur;
                cur = cur.next;
            }

        }
        return resultHead;
    }
}
