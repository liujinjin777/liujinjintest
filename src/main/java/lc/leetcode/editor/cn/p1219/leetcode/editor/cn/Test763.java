package lc.leetcode.editor.cn.p1219.leetcode.editor.cn;
//给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
//
// 注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。 
//
// 返回一个表示每个字符串片段的长度的列表。 
//
// 
//示例 1：
//
// 
//输入：s = "ababcbaca defegde hijhklij"
//输出：[9,7,8]
//解释：
//划分结果为 "ababcbaca"、"defegde"、"hijhklij" 。
//每个字母最多出现在一个片段中。
//像 "ababcbacadefegde", "hijhklij" 这样的划分是错误的，因为划分的片段数较少。 
//
// 示例 2： 
//
// 
//输入：s = "eccbbbbdec"
//输出：[10]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 500 
// s 仅由小写英文字母组成 
// 
//
// Related Topics 贪心 哈希表 双指针 字符串 👍 1087 👎 0


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution763 {
    //                  8      15
    //输入：s = "ababcbaca defegde hijhklij"
    //输出：[9,7,8]
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            map.put(charArray[i], i);
        }

        List<Integer> rets = new ArrayList<>();
        int pre = -1;
        for (int i = 0; i < charArray.length;) {
            int last = map.get(charArray[i]);
            for (; i <= last; i++) {
                int temp = map.get(charArray[i]);
                if (temp > last) {
                    last = temp;
                }
            }
            rets.add(last - pre);
            pre = last;
        }

        return rets;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
