//零钱兑换

//给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。 
//
// 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：coins = [1], amount = 1
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：coins = [1], amount = 2
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 231 - 1 
// 0 <= amount <= 104 
// 
// Related Topics 广度优先搜索 数组 动态规划 
// 👍 1415 👎 0


package cn.com.meguru.leetcode.editor.cn;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        CoinChange mainClass = new CoinChange();
        Solution solution = mainClass.new Solution();
        solution.coinChange(new int[]{1, 2, 5}, 3);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        Arrays.sort(coins);
        int[] coinNum = new int[amount + 1];
        Arrays.fill(coinNum, Integer.MIN_VALUE);
        return coinChange(coins, coinNum, amount);
    }

    private int coinChange(int[] coins, int[] count, int rem) {
        if (rem < 0) {
            return -1;
        }
        if (rem == 0) {
            return 0;
        }
        if (count[rem] != Integer.MIN_VALUE) {
            return count[rem];
        }
        int num = Integer.MAX_VALUE;
        for (int coin : coins) {
            int pre = coinChange(coins, count, rem - coin);

            if (pre >= 0 && pre < num) {
                num = pre + 1;
            }
        }
        count[rem] = num == Integer.MAX_VALUE ? -1 : num;
        return num;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}