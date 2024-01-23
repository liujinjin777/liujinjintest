package lc.leetcode.editor.cn.p1219;
//给你单链表的头结点 head ，请你找出并返回链表的中间结点。
//
// 如果有两个中间结点，则返回第二个中间结点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5]
//输出：[3,4,5]
//解释：链表只有一个中间结点，值为 3 。
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,2,3,4,5,6]
//输出：[4,5,6]
//解释：该链表有两个中间结点，值分别为 3 和 4 ，返回第二个结点。
// 
//
// 
//
// 提示： 
//
// 
// 链表的结点数范围是 [1, 100] 
// 1 <= Node.val <= 100 
// 
//
// Related Topics 链表 双指针 👍 970 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import com.liujinjin.suanfa20210506.base.ListNode;
import java.util.List;
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
public class Test876 {

    @Test
    public void test() {
        ListNode node = new ListNode(1,
            new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(middleNode(node));
        node = new ListNode(1,
            new ListNode(2,
                new ListNode(3,
                    new ListNode(4,
                        new ListNode(5,
                    new ListNode(6))))));
        System.out.println(middleNode(node));
    }

    //输入：head = [1,2,3,4,5]
    //输出：[3,4,5]
    //输入：head = [1,2,3,4,5,6]
    //输出：[4,5,6]
    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode quick = head;
        ListNode slow = head;
        while (quick.next != null && quick.next.next != null) {
            quick = quick.next.next;
            slow = slow.next;
        }

        if (quick.next == null) {
            return slow;
        }
        return slow.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)




