//不同路径

//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。 
//
// 问总共有多少条不同的路径？ 
//
// 
//
// 示例 1： 
//
// 
//输入：m = 3, n = 7
//输出：28 
//
// 示例 2： 
//
// 
//输入：m = 3, n = 2
//输出：3
//解释：
//从左上角开始，总共有 3 条路径可以到达右下角。
//1. 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右
//3. 向下 -> 向右 -> 向下
// 
//
// 示例 3： 
//
// 
//输入：m = 7, n = 3
//输出：28
// 
//
// 示例 4： 
//
// 
//输入：m = 3, n = 3
//输出：6 
//
// 
//
// 提示： 
//
// 
// 1 <= m, n <= 100 
// 题目数据保证答案小于等于 2 * 109 
// 
// Related Topics 数组 动态规划 
// 👍 993 👎 0


package cn.com.meguru.leetcode.editor.cn;

public class UniquePaths {
    public static void main(String[] args) {
        UniquePaths mainClass = new UniquePaths();
        Solution solution = mainClass.new Solution();
        solution.uniquePaths(3, 3);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    public int uniquePaths(int m, int n) {
//        Pair start = new Pair(0, 0), end = new Pair(m - 1, n - 1);
//        int[][] dp = new int[n][m];
//        uniquePaths(start, end, dp);
//        return dp[n - 1][m - 1];
//    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[n][m];
        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                int v1 = j - 1 >= 0 ? dp[j - 1][i] : 0;
                int v2 = i - 1 >= 0 ? dp[j][i - 1] : 0;
                dp[j][i] = v1 + v2;
            }
        }
        return dp[n - 1][m - 1];
    }

//    public int uniquePaths(int m, int n) {
//        int[][] dp = new int[n][m];
//        for (int[] ints : dp) {
//            ints[0] = 1;
//        }
//        for (int i = 0; i < m; i++) {
//            dp[0][i] = 1;
//        }
//        for (int i = 1; i < m; i++) {
//            for (int j = 1; j < n; j++) {
//                dp[j][i] = dp[j - 1][i] + dp[j][i - 1];
//            }
//        }
//        return dp[n - 1][m - 1];
//    }

//    private void uniquePaths(Pair cur, Pair end, int[][] dp) {
//
//    }

    //dfs超时
//    private int uniquePaths(Pair cur, Pair end, int i) {
//        if (cur.x > end.x || cur.y > end.y) {
//            return i;
//        }
//        if (cur.x == end.x && cur.y == end.y) {
//            return i + 1;
//        }
//        i = uniquePaths(new Pair(cur.x + 1, cur.y), end, i);
//        i = uniquePaths(new Pair(cur.x, cur.y + 1), end, i);
//        return i;
//    }

    class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}