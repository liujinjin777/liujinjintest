package lc.leetcode.editor.cn.p1219;
//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁴ 
// 
//
// Related Topics 数组 排序 👍 2217 👎 0


import com.alibaba.fastjson.JSON;
import java.sql.Array;
import java.util.Arrays;
import org.junit.Test;

//leetcode submit region begin(Prohibit modification and deletion)
public class Test56 {

    @Test
    public void test() {
        int[][] array = new int[4][2];
        array[0][0] = 1;
        array[0][1] = 3;
        array[1][0] = 2;
        array[1][1] = 6;
        array[2][0] = 8;
        array[2][1] = 10;
        array[3][0] = 15;
        array[3][1] = 18;
        System.out.println(JSON.toJSON(merge(array)));

        array = new int[2][2];
        array[0][0] = 1;
        array[0][1] = 3;
        array[1][0] = 4;
        array[1][1] = 5;
        System.out.println(JSON.toJSON(merge(array)));
    }

    //输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
    //输出：[[1,6],[8,10],[15,18]]
    // [1,3],[4,6]
    public int[][] merge(int[][] intervals) {
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i-1][1] >= intervals[i][0]) {
                count++;
            }
        }

        int[][] ret = new int[intervals.length-count][2];
        int l = 0;
        boolean flag = false;
        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            if (i+1 >= intervals.length || right < intervals[i+1][0]) {
                if (!flag) {
                    ret[l][0] = left;
                }
                ret[l][1] = right;
                l++;
                flag = false;
            } else {
                ret[l][0] = left;
                flag = true;
            }
        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)













