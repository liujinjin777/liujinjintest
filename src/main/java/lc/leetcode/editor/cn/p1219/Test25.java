package lc.leetcode.editor.cn.p1219;//给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
//
// k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[2,1,4,3,5]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2,3,4,5], k = 3
//输出：[3,2,1,4,5]
// 
//
// 
//提示：
//
// 
// 链表中的节点数目为 n 
// 1 <= k <= n <= 5000 
// 0 <= Node.val <= 1000 
// 
//
// 
//
// 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？ 
//
// 
// 
// Related Topics 递归 链表 👍 1960 👎 0


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
public class Test25 {

    @Test
    public void test() {
        ListNode listNode = new ListNode(1,
            new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(reverseKGroup(listNode, 4));
    }

    // 输入：head = [a,1,2,3,4,5], k = 2
    // 输入：head = [a,2,1,3,4,5], k = 2
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1 || head.next == null) {
            return head;
        }

        ListNode temp = new ListNode(0, head);
        int i = 1;
        ListNode startPre = temp;
        ListNode start = head;
        ListNode cur = head;
        while (cur != null) {
            if (i == k) {
                ListNode next = cur.next;
                revert(startPre, start, cur);
                i = 1;
                startPre = start;
                start = next;
                cur = next;
            } else {
                cur = cur.next;
                i++;
            }
        }

        return temp.next;
    }

    // 输入：head = [a,1,2,3,4,5], k = 2
    // a 1 3
    // a 1 2 3 4 5
    // a 1->5
    // a 2->1->5
    // a 3->2->1->5
    void revert(ListNode startPre, ListNode start, ListNode end) {
        ListNode head = start;
        ListNode cur = start.next;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = head;

            head = cur;
            cur = next;
            if (head == end) {
                break;
            }
        }
        start.next = cur;
        startPre.next = head;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
