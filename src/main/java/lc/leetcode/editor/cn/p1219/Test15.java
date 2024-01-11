package lc.leetcode.editor.cn.p1219;
//给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j !=
//k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请 
//
// 你返回所有和为 0 且不重复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
//解释：
//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
//不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
//注意，输出的顺序和三元组的顺序并不重要。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,1]
//输出：[]
//解释：唯一可能的三元组和不为 0 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [0,0,0]
//输出：[[0,0,0]]
//解释：唯一可能的三元组和为 0 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// Related Topics 数组 双指针 排序 👍 6611 👎 0


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.Test;

//leetcode submit region begin(Prohibit modification and deletion)
public class Test15 {

  @Test
  public void test() {
    int[] nums = {-1,0,1,-1,-4,2};
    System.out.println(threeSum1(nums));
    System.out.println(threeSum(nums));
  }

  //输入：nums = [-1,0,1,2,-1,-4]
  //输出：[[-1,-1,2],[-1,0,1]]
  // [-1,0,1,2,-1,-4]
  // [-1,0,1,2,-1,-4]
  // -4 -1 -1 0 1 2
  // -4 -1 -1 0 1 2
  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);

    List<List<Integer>> list = new ArrayList<>();
    for (int i = 0; i < nums.length - 2; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      int j = i + 1;
      int k = nums.length - 1;
      while (j < k) {
        int sum = nums[i] + nums[j] + nums[k];
        if (sum < 0) {
          j++;
        } else if (sum > 0) {
          k--;
        } else {
          list.add(Arrays.asList(nums[i], nums[j], nums[k]));
          j++;
          k--;
        }
      }
    }

    return list;
  }

  public List<List<Integer>> threeSum1(int[] nums) {
    Arrays.sort(nums);

    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], i);
    }

    List<List<Integer>> resList = new ArrayList<>();
    for (int i = 0; i < nums.length - 2; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }

      for (int j = i + 1; j < nums.length; j++) {
        int c = -nums[i] - nums[j];
        Integer index = map.get(c);
        if (index != null && index != i && index != j) {
          resList.add(Arrays.asList(nums[i], nums[j], c));
          break;
        }
      }
    }
    return resList;
  }

  /**
   * 1，排序+双指针
   * 2，排序+hash+两次for循环
   */
}
//leetcode submit region end(Prohibit modification and deletion)
