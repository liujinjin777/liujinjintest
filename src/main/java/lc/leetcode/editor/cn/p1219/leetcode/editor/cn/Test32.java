package lc.leetcode.editor.cn.p1219.leetcode.editor.cn;
//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
//
// 
//
// 
// 
// 示例 1： 
// 
// 
//
// 
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
// 
//
// 示例 2： 
//
// 
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
// 
//
// 示例 3： 
//
// 
//输入：s = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3 * 10⁴ 
// s[i] 为 '(' 或 ')' 
// 
//
// Related Topics 栈 字符串 动态规划 👍 2435 👎 0


import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution32 {

    // (()))(()())    有效()
    // )()()) 有效()()
    // (()()) 有效(()())
    public int longestValidParentheses(String s) {
        int[] array = new int[s.length()];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                if (stack.isEmpty()) {
                    continue;
                }
                int pop = stack.pop();
                array[pop] = 1;
                array[i] = 1;
            } else {
                stack.add(i);
            }
        }

        int max = 0;
        int cur = 0;
        for (int i = 0; i < s.length(); i++) {
            if (array[i] == 0) {
                cur = 0;
            } else {
                cur += array[i];
                max = Math.max(max, cur);
            }
        }

        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
