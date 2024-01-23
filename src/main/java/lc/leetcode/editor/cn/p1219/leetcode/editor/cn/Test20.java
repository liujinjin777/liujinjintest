package lc.leetcode.editor.cn.p1219.leetcode.editor.cn;
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 每个右括号都有一个对应的相同类型的左括号。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
//
// Related Topics 栈 字符串 👍 4325 👎 0


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution20 {

    /**
     * ()[]{}
     * ([])
     */
    public boolean isValid(String s) {
        Map<String, String> map = new HashMap<>();
        map.put(")", "(");
        map.put("]", "[");
        map.put("}", "{");

        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            String sub = s.substring(i, i + 1);
            System.out.println(i + " " + (i+1) + " " + sub);
            if (map.containsKey(sub)) {
                if (stack.isEmpty()) {
                    return false;
                }
                String pop = stack.pop();
                if (!map.get(sub).equals(pop)) {
                    return false;
                }
            } else {
                stack.push(sub);
            }

        }
        System.out.println(Arrays.toString(stack.toArray()));
        return stack.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
