//最佳买卖股票时机含冷冻期

//给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。 
//
// 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）: 
//
// 
// 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
// 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。 
// 
//
// 示例: 
//
// 输入: [1,2,3,0,2]
//输出: 3 
//解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出] 
// Related Topics 数组 动态规划 
// 👍 808 👎 0


package cn.com.meguru.leetcode.editor.cn;

public class BestTimeToBuyAndSellStockWithCooldown {
    public static void main(String[] args) {
        BestTimeToBuyAndSellStockWithCooldown mainClass = new BestTimeToBuyAndSellStockWithCooldown();
        Solution solution = mainClass.new Solution();
        int res = solution.maxProfit(new int[]{2, 1, 4});
        System.out.println(res);

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        this.prices = prices;
        this.memo = new Integer[prices.length][2];
        memo[0][0] = 0;
        memo[0][1] = -prices[0];
        return maxProfit(prices.length - 1, 0);
    }

    //if hold == 0, f(day, hold) = max(f(day - 1, hold), f(day - 1, !hold) + price[day])
    //if hold == 1, f(day, hold) = max(f(day - 1, hold), f(day - 2, !hold) - price[day])
    private int maxProfit(int day, int hold) {
        if (day < 0) {
            return memo[0][hold];
        }
        if (memo[day][hold] != null) {
            return memo[day][hold];
        }
        if (hold == 0) {
            memo[day][hold] = Math.max(maxProfit(day - 1, 0), maxProfit(day - 1, 1) + prices[day]);
        } else if (hold == 1) {
            memo[day][hold] = Math.max(maxProfit(day - 1, 1), maxProfit(day - 2, 0) - prices[day]);
        }
        return memo[day][hold];
    }

    int[] prices;
    //[天数][是否持有股票]
    Integer[][] memo;
}
//leetcode submit region end(Prohibit modification and deletion)

}