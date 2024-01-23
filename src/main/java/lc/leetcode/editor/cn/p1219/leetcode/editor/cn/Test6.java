package lc.leetcode.editor.cn.p1219.leetcode.editor.cn;

//将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
//
// 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下： 
//
// 
//P   A   H   N
//A P L S I I G
//Y   I   R 
//
// 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。 
//
// 请你实现这个将字符串进行指定行数变换的函数： 
//
// 
//string convert(string s, int numRows); 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "PAYPALISHIRING", numRows = 3
//输出："PAHNAPLSIIGYIR"
// 
//
//示例 2：
//
// 
//输入：s = "PAYPALISHIRING", numRows = 4
//输出："PINALSIGYAHRPI"
//解释：
//P     I    N
//A   L S  I G
//Y A   H R
//P     I
// 
//
// 示例 3： 
//
// 
//输入：s = "A", numRows = 1
//输出："A"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由英文字母（小写和大写）、',' 和 '.' 组成 
// 1 <= numRows <= 1000 
// 
//
// Related Topics 字符串 👍 2256 👎 0


import com.liujinjin.temp.testData.S;
import org.junit.Test;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution6 {

    /**
     * 012345 6789
     * PAYPAL ISHIRI NG   PAYP PAYPAL
     //P   A   H   N
     //A P L S I I G
     //Y   I   R
     * PAHNAPLSIIGYIR
     *
     //P     I    N
     //A   L S  I G
     //Y A   H R
     //P     I
     */
    public String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        int num = 2 * numRows - 2; // num=6 numRows=4
        StringBuilder sb = new StringBuilder();
        char[] array = s.toCharArray();
        for (int j = 0; j < numRows; j++) {
            // 第一行
            if (j == 0 || j == numRows - 1) {
                for (int i = j; i < array.length; i += num) {
                    sb.append(array[i]);
                }
            } else {
                int rowNum = numRows - 1; // 距离中心差数
                for (int i = j; i < array.length; i += num) {
                    sb.append(array[i]);
                    if (rowNum - i + rowNum < array.length) {
                        sb.append(array[rowNum - i + rowNum]);
                    }
                    rowNum += num;
                }
            }
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
