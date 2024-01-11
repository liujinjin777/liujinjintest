package lc.leetcode.editor.cn;
////给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
////
//// 
////
//// 示例 1： 
////
//// 
////输入：head = [1,2,3,4,5], n = 2
////输出：[1,2,3,5]
//// 
////
//// 示例 2： 
////
//// 
////输入：head = [1], n = 1
////输出：[]
//// 
////
//// 示例 3： 
////
//// 
////输入：head = [1,2], n = 1
////输出：[1]
//// 
////
//// 
////
//// 提示： 
////
//// 
//// 链表中结点的数目为 sz 
//// 1 <= sz <= 30 
//// 0 <= Node.val <= 100 
//// 1 <= n <= sz 
//// 
////
//// 
////
//// 进阶：你能尝试使用一趟扫描实现吗？ 
//// Related Topics 链表 双指针 👍 2471 👎 0
//


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
public class Test19 {

    /**
     * 输入：head = [1,2,3,4,5], n = 2
     * 输出：[1,2,3,5]
     *
     * 输入：head = [1], n = 1
     * 输出：[]
     *
     * 输入：head = [1,2], n = 1
     * 输出：[1]
     */
    @Test
    public void test() {
        ListNode head = new ListNode(1,
            new ListNode(2, new ListNode(3,
                new ListNode(4, new ListNode(5)))));
        System.out.println(removeNthFromEnd(head, 2));

        ListNode head1 = new ListNode(1);
        System.out.println(removeNthFromEnd(head1, 1));

        ListNode head2 = new ListNode(1, new ListNode(2));
        System.out.println(removeNthFromEnd(head2, 1));
    }

    /**
     *  a12345 2
     *  a12 1
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = new ListNode();
        temp.next = head;
        ListNode quick = temp;
        ListNode slow = temp;
        while (--n > 0) {
            quick = quick.next;
        }

        ListNode pre = temp;
        while (quick.next != null) {
            quick = quick.next;
            pre = slow;
            slow = slow.next;
        }
        pre.next = pre.next.next;
        return temp.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
