//目标和

//给你一个整数数组 nums 和一个整数 target 。 
//
// 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ： 
//
// 
// 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。 
// 
//
// 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1,1,1], target = 3
//输出：5
//解释：一共有 5 种方法让最终目标和为 3 。
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], target = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 20 
// 0 <= nums[i] <= 1000 
// 0 <= sum(nums[i]) <= 1000 
// -1000 <= target <= 1000 
// 
// Related Topics 数组 动态规划 回溯 👍 888 👎 0


package cn.com.meguru.leetcode.editor.cn;

import java.util.Arrays;

public class TargetSum {
    public static void main(String[] args) {
        TargetSum mainClass = new TargetSum();
        Solution solution = mainClass.new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0, dec = 0;
        for (int num : nums) {
            sum = sum + num;
        }
        if ((sum - target) % 2 != 0 || sum < target) {
            return 0;
        }
        dec = (sum - target) / 2;
        int[][] mem = new int[nums.length][dec + 1];
        for (int[] arr : mem) {
            Arrays.fill(arr, -1);
        }
        return find(nums, dec, nums.length - 1, mem);
    }

    private int find(int[] nums, int dec, int i, int[][] mem) {
        if (dec == 0 && i < 0) {
            return 1;
        }
        if (i < 0 || dec < 0) {
            return 0;
        }
        if (mem[i][dec] != -1) {
            return mem[i][dec];
        }
        int res = 0;
        res = res + find(nums, dec, i - 1, mem);
        res = res + find(nums, dec - nums[i], i - 1, mem);
        mem[i][dec] = res;
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}