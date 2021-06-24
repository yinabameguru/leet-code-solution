//买卖股票的最佳时机

//给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。 
//
// 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。 
//
// 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：[7,1,5,3,6,4]
//输出：5
//解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
// 
//
// 示例 2： 
//
// 
//输入：prices = [7,6,4,3,1]
//输出：0
//解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 105 
// 0 <= prices[i] <= 104 
// 
// Related Topics 数组 动态规划 
// 👍 1641 👎 0


package cn.com.meguru.leetcode.editor.cn;

import java.util.Arrays;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        BestTimeToBuyAndSellStock mainClass = new BestTimeToBuyAndSellStock();
        Solution solution = mainClass.new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit1(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int min = prices[0], val = 0;
        for (int price : prices) {
            int curVal = price - min;
            if (curVal > val) {
                val = curVal;
            }
            if (price < min) {
                min = price;
            }
        }
        return val;
    }

    //自顶向下动态规划f(x) = max(f(x - 1), price(x) - minprice(x - 1))
    int[] memo = null;
    int[] prices = null;
    int minprice;
    public int maxProfit(int[] prices) {
        this.prices = prices;
        memo = new int[prices.length];
        Arrays.fill(memo, -1);
        minprice = prices[0];
        return maxProfit(prices.length - 1);
    }

    private int maxProfit(int x) {
        if (x < 0) {
            return 0;
        }
        if (memo[x] != -1) {
            return memo[x];
        }
        memo[x] = Math.max(maxProfit(x - 1), prices[x] - minprice);
        if (prices[x] < minprice) {
            minprice = prices[x];
        }
        return memo[x];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}