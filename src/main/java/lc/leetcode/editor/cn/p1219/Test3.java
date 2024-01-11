package lc.leetcode.editor.cn.p1219;
//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 9861 👎 0


import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

//leetcode submit region begin(Prohibit modification and deletion)
public class Test3 {

    @Test
    public void test() {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    /*
    //输入: s = "abcabcbb"
    //输出: 3
    //输入: s = "bbbbb"
    //输出: 1
    //输入: s = "pwwkew"
    //输出: 3
     */
    public int lengthOfLongestSubstring(String s) {
        char[] charArray = s.toCharArray();
        int left = 0;
        int length = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < charArray.length; i++) {
            Integer num = map.get(charArray[i]);
            map.put(charArray[i], i);
            if (num == null) {
                length = Math.max(length, i - left + 1);
            } else {
                left = num + 1;
            }
        }
        return length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
