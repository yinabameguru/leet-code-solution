//买卖股票的最佳时机 IV

//给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。 
//
// 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1： 
//
// 
//输入：k = 2, prices = [2,4,1]
//输出：2
//解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。 
//
// 示例 2： 
//
// 
//输入：k = 2, prices = [3,2,6,5,0,3]
//输出：7
//解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
//     随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 
//。 
//
// 
//
// 提示： 
//
// 
// 0 <= k <= 100 
// 0 <= prices.length <= 1000 
// 0 <= prices[i] <= 1000 
// 
// Related Topics 数组 动态规划 
// 👍 532 👎 0


package cn.com.meguru.leetcode.editor.cn;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockIv {
    public static void main(String[] args) {
        BestTimeToBuyAndSellStockIv mainClass = new BestTimeToBuyAndSellStockIv();
        Solution solution = mainClass.new Solution();
        int res = solution.maxProfit(2, new int[]{3,2,6});
        System.out.println(res);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0 || k == 0) {
            return 0;
        }
        this.k = k;
        this.prices = prices;
        memo = new Integer[prices.length][2][k + 1];
        memo[0][0][0] = 0;
        memo[0][1][0] = -prices[0];
        int i = maxProfit(prices.length - 1, 0, k);
        System.out.println(Arrays.deepToString(memo));
        return i;
    }

    private int maxProfit(int day, int hold, int time) {
        if (day == -1 || time == -1) {
            return -2000;
        }
        if (memo[day][hold][time] != null) {
            return memo[day][hold][time];
        }
        if ((day + 1) / 2 - time < 0) {
            return maxProfit(day, hold, time - 1);
        }
        int case1 = -2000, case2 = -2000, case3 = -2000;
        if (hold == 0) {
            case1 = maxProfit(day - 1, 0, time);
            case2 = maxProfit(day - 1, 1, time - 1) + prices[day];
        } else if (hold == 1) {
            case1 = maxProfit(day - 1, 1, time);
            case3 = maxProfit(day - 1, 0, time) - prices[day];
        }
        memo[day][hold][time] = Math.max(Math.max(case1, case2), case3);
        return memo[day][hold][time];
    }

    //[天数][是否持股][出售次数]
    Integer[][][] memo = null;
    int k;
    int[] prices = null;
}
//leetcode submit region end(Prohibit modification and deletion)

}