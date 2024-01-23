package lc.leetcode.editor.cn.p1219.leetcode.editor.cn;
//给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
//
// 
//
// 示例 1： 
//
// 
//输入：s = "bcabc"
//输出："abc"
// 
//
// 示例 2： 
//
// 
//输入：s = "cbacdcbc"
//输出："acdb"
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 由小写英文字母组成 
// 
//
// 
//
// 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-
//distinct-characters 相同 
//
// Related Topics 栈 贪心 字符串 单调栈 👍 1032 👎 0


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // bcabc
    public String removeDuplicateLetters(String s) {
        int[] countArray = new int[26];
        for (int i = 0; i < s.length(); i++) {
            countArray[s.charAt(i) - 'a'] = i;
        }
        //System.out.println(Arrays.toString(countArray));

        Deque<Character> deque = new ArrayDeque<>();
        boolean[] exist = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!exist[c - 'a']) {
                while (!deque.isEmpty() && deque.getLast() > c && countArray[deque.getLast() - 'a'] > i) {
                    Character last = deque.removeLast();
                    exist[last - 'a'] = false;
                }
                deque.addLast(c);
                exist[c - 'a'] = true;
                //System.out.println("deque " + deque + " " + Arrays.toString(countArray));
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.pollFirst());
        }

        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
