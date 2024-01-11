package lc.leetcode.editor.cn.p1219;
//给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[4,5,1,2,3]
// 
//
// 示例 2： 
// 
// 
//输入：head = [0,1,2], k = 4
//输出：[2,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 500] 内 
// -100 <= Node.val <= 100 
// 0 <= k <= 2 * 10⁹ 
// 
//
// Related Topics 链表 双指针 👍 1016 👎 0


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
public class Test61 {

    @Test
    public void test() {
        ListNode node = new ListNode(0, new ListNode(1, new ListNode(2)));
        System.out.println(rotateRight(node, 4));
    }

    //输入：head = [0,1,2], k = 4
    //输出：[2,0,1]
    //输入：head = [1,2,3,4,5], k = 2
    //输出：[4,5,1,2,3]
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode temp = head;
        int i = 0;
        ListNode pre = null;
        while (temp != null) {
            pre = temp;
            temp = temp.next;
            i++;
        }
        // 形成环
        pre.next = head;

        int j = i - k % i;
        temp = head;
        i = 1;
        while (temp != null) {
            if (i == j) {
                ListNode next = temp.next;
                temp.next = null;
                return next;
            }
            temp = temp.next;
            i++;
        }

        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
