package com.liujinjin.suanfa20210506.node;

import com.liujinjin.suanfa20210506.base.ListNode;

/**
 * @author liuxin14 <liuxin14@kuaishou.com>
 * Created on 2021-05-07
 */
@SuppressWarnings("checkstyle:TypeName")
public class t2 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3, null)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(7, null)));
        System.out.println(addTwoNumbers(l1, l2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 是否有进位
        boolean isCarry = false;
        ListNode head = null;
        ListNode cur = null;
        while (l1 != null || l2 != null) {
            int l1Val = l1 == null ? 0 : l1.val;
            int l2Val = l2 == null ? 0 : l2.val;
            int val = l1Val + l2Val;
            if (isCarry) {
                val += 1;
                isCarry = false;
            }
            // 是否有进位
            if (val >= 10) {
                val = val - 10;
                isCarry = true;
            }
            // 第一次时
            if (cur == null) {
                cur = new ListNode(val);
                head = cur;
            } else {
                cur.next = new ListNode(val);
                cur = cur.next;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (isCarry) {
            cur.next = new ListNode(1);
        }

        return head;
    }
}
