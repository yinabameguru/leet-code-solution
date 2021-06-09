//最大正方形

//在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：matrix = [["0","1"],["1","0"]]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：matrix = [["0"]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 300 
// matrix[i][j] 为 '0' 或 '1' 
// 
// Related Topics 动态规划 
// 👍 783 👎 0


package cn.com.meguru.leetcode.editor.cn;

import java.util.Arrays;

public class MaximalSquare {
    public static void main(String[] args) {
        MaximalSquare mainClass = new MaximalSquare();
        Solution solution = mainClass.new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            if (matrix[i][0] == '1') {
                dp[i][0] = 1;
                if (res == 0) {
                    res = 1;
                }
            }
        }
        for (int i = 0; i < dp[0].length; i++) {
            if (matrix[0][i] == '1') {
                dp[0][i] = 1;
                if (res == 0) {
                    res = 1;
                }
            }
        }
        for (int y = 1; y < dp.length; y++) {
            for (int x = 1; x < dp[0].length; x++) {
                if (matrix[y][x] == '1') {
                    dp[y][x] = Math.min(dp[y - 1][x], Math.min(dp[y - 1][x - 1], dp[y][x - 1])) + 1;
                    if (dp[y][x] > res) {
                        res = dp[y][x];
                    }
                }
            }
        }
        return res * res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}