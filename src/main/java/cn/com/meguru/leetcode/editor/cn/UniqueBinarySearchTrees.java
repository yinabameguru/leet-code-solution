//不同的二叉搜索树

//给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：5
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 19 
// 
// Related Topics 树 动态规划 
// 👍 1161 👎 0


package cn.com.meguru.leetcode.editor.cn;

import java.util.Arrays;

public class UniqueBinarySearchTrees {
    public static void main(String[] args) {
        UniqueBinarySearchTrees mainClass = new UniqueBinarySearchTrees();
        Solution solution = mainClass.new Solution();
        solution.numTrees(3);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    //自顶向下记忆集
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        dp[1] = 1;
        return num(n, dp);
    }

    private int num(int n, int[] dp) {
        if (n == 1) {
            return 1;
        }
        if (dp[n] >= 0) {
            return dp[n];
        }
        int val = 0;
        for (int i = 1; i < n + 1; i++) {
            val = val + num(i - 1, dp) * num(n - i, dp);
        }
        return val;
    }

    //自底向上
    public int numTrees2(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            int val = 0;
            for (int j = 1; j <= i; j++) {
                val = val + dp[j - 1] * dp[i - j];
            }
            dp[i] = val;
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}