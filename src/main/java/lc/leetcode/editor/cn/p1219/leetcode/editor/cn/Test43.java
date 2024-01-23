package lc.leetcode.editor.cn.p1219.leetcode.editor.cn;


//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
//
// 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。 
//
// 
//
// 示例 1: 
//
// 
//输入: num1 = "2", num2 = "3"
//输出: "6" 
//
// 示例 2: 
//
// 
//输入: num1 = "123", num2 = "456"
//输出: "56088" 
//
// 
//
// 提示： 
//
// 
// 1 <= num1.length, num2.length <= 200 
// num1 和 num2 只能由数字组成。 
// num1 和 num2 都不包含任何前导零，除了数字0本身。 
// 
//
// Related Topics 数学 字符串 模拟 👍 1315 👎 0


import com.liujinjin.temp.testData.S;
import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution43 {


    // 123
    // 456  56088
    //     6 12 18
    //  5 10 15
    //4 8 12
    //1 0 0  0  0
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)){
            return "0";
        }

        int[] array = new int[num1.length() + num2.length() - 1];
        for (int i = 0; i < num1.length(); i++) {
            int numI = Character.getNumericValue(num1.charAt(i));
            for (int j = 0; j < num2.length(); j++) {
                int numJ = Character.getNumericValue(num2.charAt(j));
                array[i+j] += numI * numJ;
            }
        }
        // System.out.println(Arrays.toString(array));
        StringBuilder sb = new StringBuilder();
        int yu = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            int n = array[i] + yu;
            if (n >= 10) {
                sb.append(n % 10);
                yu = n / 10;
            } else {
                sb.append(n);
                yu = 0;
            }
        }
        if (yu > 0) {
            sb.append(yu);
        }
        return sb.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
