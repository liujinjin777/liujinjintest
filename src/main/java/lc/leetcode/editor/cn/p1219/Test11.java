package lc.leetcode.editor.cn.p1219;//给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
//
// 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 返回容器可以储存的最大水量。 
//
// 说明：你不能倾斜容器。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
//解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 示例 2： 
//
// 
//输入：height = [1,1]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 2 <= n <= 10⁵ 
// 0 <= height[i] <= 10⁴ 
// 
//
// Related Topics 贪心 数组 双指针 👍 4754 👎 0


import org.junit.Test;

//leetcode submit region begin(Prohibit modification and deletion)
public class Test11 {

    @Test
    public void test() {
        System.out.println(maxArea(new int[]{1, 1}));
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int num = Math.min(height[left], height[right]) * (right - left);
        while (left < right) {
            int leftNum = height[left];
            int rightNum = height[right];
            if (leftNum < rightNum) {
                while (left < right && height[left] <= leftNum) {
                    left++;
                }
            } else {
                while (left < right && height[right] <= rightNum) {
                    right--;
                }
            }
            int temp = Math.min(height[left], height[right]) * (right - left);
            System.out.println(temp + " l=" + left + " r=" + right);
            num = Math.max(num, temp);
        }

        return num;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
