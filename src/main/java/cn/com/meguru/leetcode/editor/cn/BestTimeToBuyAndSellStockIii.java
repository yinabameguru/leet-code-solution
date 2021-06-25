//买卖股票的最佳时机 III

//给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。 
//
// 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1: 
//
// 
//输入：prices = [3,3,5,0,0,3,1,4]
//输出：6
//解释：在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
//     随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。 
//
// 示例 2： 
//
// 
//输入：prices = [1,2,3,4,5]
//输出：4
//解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。   
//     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。   
//     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
// 
//
// 示例 3： 
//
// 
//输入：prices = [7,6,4,3,1] 
//输出：0 
//解释：在这个情况下, 没有交易完成, 所以最大利润为 0。 
//
// 示例 4： 
//
// 
//输入：prices = [1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 105 
// 0 <= prices[i] <= 105 
// 
// Related Topics 数组 动态规划 
// 👍 804 👎 0


package cn.com.meguru.leetcode.editor.cn;

public class BestTimeToBuyAndSellStockIii {
    public static void main(String[] args) {
        BestTimeToBuyAndSellStockIii mainClass = new BestTimeToBuyAndSellStockIii();
        Solution solution = mainClass.new Solution();
        solution.maxProfit(new int[]{1, 2, 3, 4});
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {


    public int maxProfit(int[] prices) {
        memo = new Integer[prices.length][2][3];
        this.prices = prices;
        return maxProfit(prices.length - 1, 0, 2);
    }

    private int maxProfit(int day, int hold, int sellTime) {
        if (memo[day][hold][sellTime] != null) {
            return memo[day][hold][sellTime];
        }
        if (day == 0) {
            if (hold == 0) {
                return 0;
            } else {
                return -prices[0];
            }
        }
        if (hold == 1) {
            memo[day][hold][sellTime] = Math.max(maxProfit(day - 1, 1, sellTime),
                    maxProfit(day - 1, 0, sellTime) - prices[day]);
        } else if (hold == 0) {
            if (sellTime == 0) {
                memo[day][hold][sellTime] = maxProfit(day - 1, 0, 0);
            } else if (sellTime == 1) {
                memo[day][hold][sellTime] = Math.max(maxProfit(day - 1, 0, 1),
                        maxProfit(day - 1, 1, 0) + prices[day]);
            } else if (sellTime == 2) {
                memo[day][hold][sellTime] = Math.max(maxProfit(day - 1, 0, 2),
                        maxProfit(day - 1, 1, 1) + prices[day]);
            }
        }
        return memo[day][hold][sellTime];
    }

    //[天数][是否持股][出售次数]
    Integer[][][] memo = null;

    //记忆化搜索，超时
    public int maxProfit1(int[] prices) {
        this.prices = prices;
//        memo = new Integer[prices.length][prices.length];
        int res = 0;
        int endIdx = prices.length - 1;
        for (int i = endIdx; i > 0; i--) {
            minPrice = prices[0];
            maxProfit = null;
            int left = maxProfit(0, i);
            int right = 0;
            if ((i + 1 < endIdx)) {
                minPrice = prices[i + 1];
                maxProfit = null;
                right = maxProfit(i + 1, endIdx);
            }
            res = Math.max(res, left + right);
        }
        return res;
    }

    private int maxProfit(int startIdx, int endIdx) {
        if (startIdx > endIdx) {
            return 0;
        }
        if (maxProfit == null) {
            maxProfit = Math.max(maxProfit(startIdx, endIdx - 1), prices[endIdx] - minPrice);
            minPrice = Math.min(prices[endIdx], minPrice);
        }
        return maxProfit;
    }

    int[] prices = null;
    int minPrice;
    Integer maxProfit;
}
//leetcode submit region end(Prohibit modification and deletion)

}