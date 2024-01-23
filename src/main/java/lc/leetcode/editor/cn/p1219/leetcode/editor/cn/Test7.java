package lc.leetcode.editor.cn.p1219.leetcode.editor.cn;

//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−2³¹, 231 − 1] ，就返回 0。 
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
// 
//
// 示例 1：
//输入：x = 123
//输出：321
//
// 示例 2：
//输入：x = -123
//输出：-321
//
// 示例 3：
//输入：x = 120
//输出：21
//
// 示例 4：
//输入：x = 0
//输出：0
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
// Related Topics 数学 👍 3953 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution7 {

    // x=123
    public int reverse(int x) {
        int ret = 0;
        // -2147483648到+2147483647
        while (Math.abs(x) > 0) {
            if (ret > 0) {
                if (ret > Integer.MAX_VALUE / 10 || (ret == Integer.MAX_VALUE / 10 && x % 10 > 7)) {
                    return 0;
                }
            } else if (ret < 0) {
                if (ret < Integer.MIN_VALUE / 10 || (ret == Integer.MIN_VALUE / 10 && x % 10 < -8)) {
                    return 0;
                }
            }
            ret = ret * 10 + x % 10; // 32
            x /= 10; // 1
        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
