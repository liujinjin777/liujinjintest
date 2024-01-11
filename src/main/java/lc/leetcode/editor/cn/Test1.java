package lc.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

/**
 * Created by liuxin on 2023/12/19.
 */
public class Test1 {

  @Test
  public void test() {
    int[] nums = {2, 7, 11, 15};
    System.out.println(Arrays.toString(twoSum(nums, 9)));
    int[] nums1 = {3, 2, 4};
    System.out.println(Arrays.toString(twoSum(nums1, 6)));
    int[] nums2 = {3, 3};
    System.out.println(Arrays.toString(twoSum(nums2, 6)));
  }

  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], i);
    }
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      int key = entry.getKey();
      int value = entry.getValue();
      Integer v2 = map.get(target - key);
      if (v2 != null && v2 != value) {
        return new int[]{value, v2};
      }
    }

    return null;
  }
}
