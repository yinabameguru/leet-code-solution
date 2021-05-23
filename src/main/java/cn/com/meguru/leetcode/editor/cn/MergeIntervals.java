//合并区间

//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。 
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
// 1 <= intervals.length <= 104 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 104 
// 
// Related Topics 排序 数组 
// 👍 929 👎 0


package cn.com.meguru.leetcode.editor.cn;

import cn.com.meguru.helper.Helper;

import java.util.*;
import java.util.stream.Collectors;

public class MergeIntervals {
    public static void main(String[] args) {
        MergeIntervals mainClass = new MergeIntervals();
        Solution solution = mainClass.new Solution();
//        int[][] merge = solution.merge(new int[][]{{1,3}, {2,3}, {2,6}, {15,18}});
        int[][] merge = solution.merge(Helper.toArray("[[2,3],[2,2],[3,3],[1,3],[5,7],[2,2],[4,6]]"));
        System.out.println(Arrays.toString(merge));
    }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }
        intervals = Arrays.stream(intervals)
                .sorted(Comparator.comparingInt(o -> o[0]))
                .toArray(int[][]::new);
        List<int[]> list = new ArrayList<>();

//        int[] pre = intervals[0];
        int i = 1, j = 0;
        list.add(intervals[j]);
        while (i < intervals.length) {
            int[] cur = intervals[i];
            int[] pre = list.get(j);
            if (pre[1] >= cur[1]) {
//                list.add(cur);
                i = i + 1;
//                pre = cur;
            } else if (pre[1] >= cur[0]) {
                int[] ints = {pre[0], cur[1]};
                list.set(j, ints);
                i = i + 1;
            } else {
                list.add(cur);
                i = i + 1;
                j = j + 1;
            }
        }
        int[][] res = list.stream().toArray(int[][]::new);
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}