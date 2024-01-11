package lc.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

/**
 * Created by liuxin on 2023/12/19.
 */
public class Test387 {

  @Test
  public void test() {
    System.out.println(firstUniqChar("leetcode"));
    System.out.println(firstUniqChar("loveleetcode"));
    System.out.println(firstUniqChar("aabb"));
  }

  public int firstUniqChar(String s) {
    char[] array = s.toCharArray();
    Map<Character, Integer> map = new HashMap<>();
    for (char c : array) {
      int value = map.getOrDefault(c, 0);
      map.put(c, ++value);
    }

    for (int i = 0; i < array.length; i++) {
      if (map.get(array[i]) == 1) {
        return i;
      }
    }
    return -1;
  }
}
