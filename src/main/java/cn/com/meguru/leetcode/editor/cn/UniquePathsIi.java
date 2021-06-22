//不同路径 II

//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。 
//
// 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？ 
//
// 
//
// 网格中的障碍物和空位置分别用 1 和 0 来表示。 
//
// 
//
// 示例 1： 
//
// 
//输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
//输出：2
//解释：
//3x3 网格的正中间有一个障碍物。
//从左上角到右下角一共有 2 条不同的路径：
//1. 向右 -> 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右 -> 向右
// 
//
// 示例 2： 
//
// 
//输入：obstacleGrid = [[0,1],[0,0]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// m == obstacleGrid.length 
// n == obstacleGrid[i].length 
// 1 <= m, n <= 100 
// obstacleGrid[i][j] 为 0 或 1 
// 
// Related Topics 数组 动态规划 
// 👍 572 👎 0


package cn.com.meguru.leetcode.editor.cn;

import java.util.Arrays;

public class UniquePathsIi {
    public static void main(String[] args) {
        UniquePathsIi mainClass = new UniquePathsIi();
        Solution solution = mainClass.new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }
        dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1] = 1;
        return uniquePathsWithObstacles(0, 0, obstacleGrid[0].length - 1, obstacleGrid.length - 1, dp, obstacleGrid);
    }

    private int uniquePathsWithObstacles(int xcur, int ycur, int xend, int yend, int[][] dp, int[][] obstacleGrid) {
        if (xcur > xend || ycur > yend || obstacleGrid[ycur][xcur] == 1) {
            return 0;
        }
        if (dp[ycur][xcur] < 0) {
            dp[ycur][xcur] = uniquePathsWithObstacles(xcur + 1, ycur, xend, yend, dp, obstacleGrid) +
                    uniquePathsWithObstacles(xcur, ycur + 1, xend, yend, dp, obstacleGrid);
        }
        return dp[ycur][xcur];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}