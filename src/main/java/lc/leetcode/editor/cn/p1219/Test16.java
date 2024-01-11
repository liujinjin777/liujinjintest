package lc.leetcode.editor.cn.p1219;
//给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
//
// 返回这三个数的和。 
//
// 假定每组输入只存在恰好一个解。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,0,0], target = 1
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 1000 
// -1000 <= nums[i] <= 1000 
// -10⁴ <= target <= 10⁴ 
// 
//
// Related Topics 数组 双指针 排序 👍 1569 👎 0


import java.lang.reflect.Array;
import java.util.Arrays;
import org.junit.Test;

//leetcode submit region begin(Prohibit modification and deletion)
public class Test16 {

    @Test
    public void test() {
        int[] array = {-1,2,1,-4};
        System.out.println(threeSumClosest(array, 1));

        int[] array2 = {0,0,0};
        System.out.println(threeSumClosest(array2, 1));
    }

    // -4 -1 1 2 3 4     2
    public int threeSumClosest(int[] nums, int target) {
        int sum = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int s = nums[i] + nums[j] + nums[k];
                int diff = s - target;
                if (Math.abs(diff) < Math.abs(sum - target)) {
                    sum = s;
                }

                if (diff < 0) {
                    j++;
                } else if (diff > 0) {
                    k--;
                } else {
                    return target;
                }
            }
        }

        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
