package lc.leetcode.editor.cn;//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
// Related Topics 递归 链表 数学 👍 9403 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import com.liujinjin.suanfa20210506.base.ListNode;
import org.junit.Test;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Test2 {

    @Test
    public void test() {
        // l1 = [2,4,3], l2 = [5,6,4]
        // l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9] [8,9,9,9,0,0,0,1]
        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9,
            new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        System.out.println(addTwoNumbers(l1, l2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        int yu = 0;
        ListNode temp = new ListNode();
        ListNode cur = temp;
        while (l1 != null || l2 != null) {
            int value1 = (l1 != null ? l1.val : 0);
            int value2 = (l2 != null ? l2.val : 0);

            int sum = value1 + value2 + yu;
            yu = 0;
            if (sum >= 10) {
                yu++;
                sum = sum % 10;
            }
            cur.next = new ListNode(sum);
            cur = cur.next;
            l1 =  (l1 != null ? l1.next : null);
            l2 =  (l2 != null ? l2.next : null);
        }
        if (yu != 0) {
            cur.next = new ListNode(1);
        }

        return temp.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
