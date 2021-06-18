//完全平方数

//给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。 
//
// 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。 
//
// 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
// 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 12
//输出：3 
//解释：12 = 4 + 4 + 4 
//
// 示例 2： 
//
// 
//输入：n = 13
//输出：2
//解释：13 = 4 + 9 
// 
//
// 提示： 
//
// 
// 1 <= n <= 104 
// 
// Related Topics 广度优先搜索 数学 动态规划 
// 👍 984 👎 0


package cn.com.meguru.leetcode.editor.cn;

import java.util.Arrays;

public class PerfectSquares {
    public static void main(String[] args) {
        PerfectSquares mainClass = new PerfectSquares();
        Solution solution = mainClass.new Solution();
        solution.numSquares(121);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numSquares(int n) {
        int[] nums = new int[100];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i * i;
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        int res = numSquares(nums, dp, n);
        return res;
    }

    //备忘录自顶向下动态规划
    private int numSquares(int[] nums, int[] dp, int n) {
        if (dp[n] > 0) {
            return dp[n];
        }
        int res = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > n) {
                break;
            }
            if (nums[i] == n) {
                res = 1;
                continue;
            }
            if (nums[i] < n) {
                if (dp[n] > 0) {
                    res = Math.min(res, dp[n]);
                } else {
                    int curCount = numSquares(nums, dp, n - nums[i]) + 1;
                    res = res > 0 ? Math.min(res, curCount) : curCount;
                }
            }
        }
        dp[n] = res;
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}