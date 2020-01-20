package com.liujinjin.suanfa190622;

import org.junit.Test;

/**
 *
 * 大致思路：遍历两个链表，如果l1 < l2, 插到l2前（两种情况：l2前无节点，l2前有节点）
 * 注意点：
 *  1，当l2为null，l1还有剩余链表，需要把l1剩余放在l2后面
 *  2，最后一步，再设置l1 = l1.next
 * 关键点：
 *  任务拆解，练习把l1的2插入到l2的2前   和  l2的4前
 *
 * @author liuxin
 * @date 2019/6/22
 */
public class T21LinkedMerge {

    @Test
    public void test(){
        ListNode l1 = new ListNode(2, new ListNode(3, new ListNode(4, null)));
        ListNode l2 = new ListNode(2, new ListNode(4, new ListNode(6, null)));
        ListNode merge = this.merge(l1, l2);
        System.out.println(merge);
    }

    /**
     * l1: 2->3->4->null
     * l2: 2->4->6->null
     */
    public ListNode merge(ListNode l1, ListNode l2){
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        ListNode l2Pre = null;
        ListNode head = l2;
        while (l1 != null && l2 != null) {
            if(l1.val < l2.val){
                ListNode l1Next = l1.next;
                l1.next = l2;
                if(l2Pre != null){
                    l2Pre.next = l1;
                } else {
                    head = l1;
                }
                l2Pre = l1;
                l1 = l1Next;
            } else {
                l2Pre = l2;
                l2.next = l2;
            }
        }

        if(l2 == null){
            l2.next = l1;
        }

        return head;
    }

}
