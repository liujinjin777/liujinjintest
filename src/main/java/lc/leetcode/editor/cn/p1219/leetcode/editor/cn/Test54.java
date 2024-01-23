package lc.leetcode.editor.cn.p1219.leetcode.editor.cn;
//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
//
// Related Topics 数组 矩阵 模拟 👍 1586 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution54 {

    /**
     * [
     *  [1,2,3,4,9],
     *  [5,6,7,8,9],
     *  [5,6,7,8,9],
     *  [5,6,7,8,9],
     *  [5,6,7,8,9],
     *  [9,10,11,12,9]
     * ]
     *
     *
     * [1,2,3,4],
     * [5,6,7,8],
     * [9,10,11,12]
     *
     * 1 3   1,0  0,3  i=1-2 j=0-3
     * 0 2   0,0  2,0
     * rowStart++  powEnd--
     * powStart++  rowEnd--
     * 下到上2 左到右2  i=2-1 j=1-2
     * 右到左1 上到下1
     * 【1，2】
     * 2  1
     * 1  1
     *
     *
     * 1
     *
     * 1 0 i=1-0 j=0-0
     * 0 0
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int i = 0; // 1
        int j = 0; // 2
        int rowStart = 1; // 1 2
        int rowEnd = matrix.length - 1; // 2 1
        int powStart = 0; // 0 1
        int powEnd = matrix[0].length - 1; // 3 2 1
        while (true) {
            // 上左-》上右
            if (!(powStart <= j && j <= powEnd)) {
                break;
            }
            for (; j <= powEnd; j++) {
                list.add(matrix[i][j]);
            }
            j--;
            powEnd--;
            i++;

            // 上右-》下右
            if (!(rowStart <= i && i <= rowEnd)) {
                break;
            }
            for (; i <= rowEnd; i++) {
                list.add(matrix[i][j]);
            }
            i--;
            rowEnd--;
            j--;

            // 下右-》下左
            if (!(powStart <= j && j <= powEnd)) {
                break;
            }
            for (; j >= powStart; j--) {
                list.add(matrix[i][j]);
            }
            j++;
            powStart++;
            i--;

            // 下左->上右
            if (!(rowStart <= i && i <= rowEnd)) {
                break;
            }
            for (; i >= rowStart; i--) {
                list.add(matrix[i][j]);
            }
            i++;
            rowStart++;
            j++;
        }

        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
