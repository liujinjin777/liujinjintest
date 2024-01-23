package lc.leetcode.editor.cn.p1219.leetcode.editor.cn;



//给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
//
// 请你找出符合题意的 最短 子数组，并输出它的长度。 
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
//输入：nums = [2,6,4,8,10,9,15]
//输出：5
//解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4]
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// 
//
// 进阶：你可以设计一个时间复杂度为 O(n) 的解决方案吗？ 
//
// Related Topics 栈 贪心 数组 双指针 排序 单调栈 👍 1119 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution581 {

    /*
    [2,6,4,8,10,9,15]
    [6, 4, 8, 10, 9]

    12333
    13222
    23324
     */
    public int findUnsortedSubarray(int[] nums) {
        int right = 0;
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < max) {
                right = i;
            }
            max = Math.max(max, nums[i]);
        }

        int left = nums.length - 1;
        int min = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > min) {
                left = i;
            }
            min = Math.min(min, nums[i]);
        }
        if (right <= left) {
            return 0;
        }
        return right - left + 1;
    }

    /**
     * 左面循环依次找大的，找最右侧的小值
     * 右面循环依次找小的，找最左面的大值 ！！
     */
}
//leetcode submit region end(Prohibit modification and deletion)
