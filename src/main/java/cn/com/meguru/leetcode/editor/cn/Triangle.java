//三角形最小路径和

//给定一个三角形 triangle ，找出自顶向下的最小路径和。 
//
// 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果
//正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
//输出：11
//解释：如下面简图所示：
//   2
//  3 4
// 6 5 7
//4 1 8 3
//自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
// 
//
// 示例 2： 
//
// 
//输入：triangle = [[-10]]
//输出：-10
// 
//
// 
//
// 提示： 
//
// 
// 1 <= triangle.length <= 200 
// triangle[0].length == 1 
// triangle[i].length == triangle[i - 1].length + 1 
// -104 <= triangle[i][j] <= 104 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？ 
// 
// Related Topics 数组 动态规划 
// 👍 779 👎 0


package cn.com.meguru.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
    public static void main(String[] args) {
        Triangle mainClass = new Triangle();
        Solution solution = mainClass.new Solution();
        List<List<Integer>> list = List.of(List.of(2), List.of(3, 4), List.of(6, 5, 7));
        solution.minimumTotal(list);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    List<List<Integer>> memo = new ArrayList<>();
    List<List<Integer>> triangle = null;

    public int minimumTotal(List<List<Integer>> triangle) {
        this.triangle = triangle;
        for (List<Integer> list : triangle) {
            ArrayList<Integer> memoitem = new ArrayList<>();
            memo.add(memoitem);
            for (Integer integer : list) {
                memoitem.add(null);
            }
        }
        return minimumTotal(0, 0);
    }

    private int minimumTotal(int y, int x) {
        if (y == triangle.size() || x == triangle.get(y).size()) {
            return 0;
        }
        if (memo.get(y).get(x) == null) {
            int val = Math.min(triangle.get(y).get(x) + minimumTotal(y + 1, x), triangle.get(y).get(x) + minimumTotal(y + 1, x + 1));
            memo.get(y).set(x, val);
        }
        return memo.get(y).get(x);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}