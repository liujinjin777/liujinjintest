package lc.leetcode.editor.cn.p1219.leetcode.editor.cn;



//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
//
// Related Topics 位运算 数组 回溯 👍 2229 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> rets = new ArrayList<>();
        LinkedList<Integer> queue = new LinkedList<>();
        dfs(nums, 0, queue, rets);
        rets.add(new ArrayList<>());
        return rets;
    }

    /**
     *    1     2     3
     *  2  3   3
     * 3
     */
    public void dfs(int[] nums, int i, LinkedList<Integer> queue, List<List<Integer>> rets) {
        if (i == nums.length) {
            return;
        }

        // ret 1 12 123
        while (i < nums.length) {
            queue.add(nums[i]);
            rets.add(new ArrayList<>(queue));
            dfs(nums, ++i, queue, rets);
            queue.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
