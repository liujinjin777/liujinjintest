package lc.leetcode.editor.cn.p1219.leetcode.editor.cn;

//给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
//
// 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。 
//
// 
// 例如，121 是回文，而 123 不是。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 121
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：x = -121
//输出：false
//解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 
//
// 示例 3： 
//
// 
//输入：x = 10
//输出：false
//解释：从右向左读, 为 01 。因此它不是一个回文数。
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= x <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能不将整数转为字符串来解决这个问题吗？ 
//
// Related Topics 数学 👍 2770 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution9 {

    // 12221
    // 1  100000
    // 20 2000
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int n = 0;
        int temp = x;
        while (temp > 0) {
            temp /= 10;
            n++;
        }

        for (int i = 0; i < n/2; i++) {
            int left = (int) ((x % Math.pow(10, i + 1)) / Math.pow(10, i));
            int right = (int) (x / Math.pow(10, n - i - 1)) % 10;
            System.out.println(left + " " + right);
            if (left != right) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
