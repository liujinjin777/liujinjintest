package com.liujinjin.suanfa190622;

import org.junit.Test;

/**
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
   输出：7 -> 0 -> 8
   原因：342 + 465 = 807
 *
 * @author liuxin
 * @date 2019/7/1
 */
public class T2AddTwoNumber {

    @Test
    public void test(){
        ListNode listNode1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode listNode2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        System.out.println(this.addTwoNumbers(listNode1, listNode2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode1Cur = l1;
        ListNode listNode2Cur = l2;
        ListNode head = null;
        ListNode headCur = null;
        int num = 0;

        while(listNode1Cur != null || listNode2Cur != null){
            int val1 = listNode1Cur == null ? 0 : listNode1Cur.val;
            int val2 = listNode2Cur == null ? 0 : listNode2Cur.val;

            int sum = val1 + val2 + num;
            num = sum / 10;
            sum = sum % 10;

            if(head == null){
                head = new ListNode(sum);
                headCur = head;
            } else {
                headCur.next = new ListNode(sum);
                headCur = headCur.next;
            }

            if(listNode1Cur != null){
                listNode1Cur = listNode1Cur.next;
            }
            if(listNode2Cur != null){
                listNode2Cur = listNode2Cur.next;
            }
        }

        return head;
    }

}
