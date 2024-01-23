package lc.leetcode.editor.cn.p1219.leetcode.editor.cn;

//给定一个整数 n ，返回 n! 结果中尾随零的数量。
//
// 提示 n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：0
//解释：3! = 6 ，不含尾随 0
// 
//
// 示例 2： 
//
// 
//输入：n = 5
//输出：1
//解释：5! = 120 ，有一个尾随 0
//  1 2 3 4 5 7 8 9 10
// 10
// 2*5 or 4*5
// 示例 3： 
//
// 
//输入：n = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 10⁴ 
// 
//
// 
//
// 进阶：你可以设计并实现对数时间复杂度的算法来解决此问题吗？ 
//
// Related Topics 数学 👍 813 👎 0


import com.alibaba.fastjson.JSON;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution172 {
    //输入：n = 5
    //输出：1
    //解释：5! = 120 ，有一个尾随 0
    //  1   2  3  4  5  6  7  8  9 10
    //  11 12 13 14 15 16 17 18 19 20
    //  21 22 23 24 25 26 27 28 29 30
    // 10
    // 2*5 or 4*5
    // 5 10 15 25 30 35 40 45 50 55 60 65 70 75 80
    public int trailingZeroes(int n) {
        int ret = 0;
        while (n > 0) {
            ret += n / 5;
            n /= 5;
        }
        return ret;
    }
    // 有多少个5的因子。
}
//leetcode submit region end(Prohibit modification and deletion)
