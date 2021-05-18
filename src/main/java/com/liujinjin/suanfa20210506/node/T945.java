package com.liujinjin.suanfa20210506.node;

import java.util.Arrays;

import org.junit.Test;

import com.liujinjin.suanfa190622.ListNode;
import com.sun.org.apache.xpath.internal.operations.String;

/**
 * @author liuxin14 <liuxin14@kuaishou.com>
 * Created on 2021-05-12
 */
public class T945 {

    @Test
    public ListNode test(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            if (val == cur.val) {
                if (pre == null) {
                    head = head.next;
                    cur = head;
                } else {
                    pre = cur.next;
                    cur = pre.next;
                }
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return head;
    }

    public int minIncrementForUnique(int[] a) {
        if (a == null || a.length <= 1) {
            return 0;
        }
        int[] b = a.clone();
        Arrays.sort(b);

        int beforeNum = b[0]; // 3
        int count = 0; // 4
        // 1 1 2 2 3 7
        for (int i = 1; i < b.length; i++) {
            int bVal = b[i];
            if (bVal <= beforeNum) {
                count += bVal - beforeNum + 1;
                beforeNum = beforeNum + 1;
            } else {
                beforeNum = bVal;
            }
        }
        return count;
    }
}
