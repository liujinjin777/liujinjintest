package lc.leetcode.editor.cn.p1219;//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
//
// 
// 
// 
// 
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,2]
//输出：[2,1]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= Node.val <= 5000 
// 
//
// 
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？ 
//
// Related Topics 递归 链表 👍 3449 👎 0


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
public class Test206 {

    @Test
    public void test() {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        System.out.println(listNode);
        System.out.println(reverseList(listNode));
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        // 1->2->3->4->5
        // 2->1->3->4->5
        ListNode cur = head;
        while(cur.next != null) {
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = head;
            head = next;
        }

        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
