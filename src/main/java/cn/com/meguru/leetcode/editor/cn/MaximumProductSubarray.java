//乘积最大子数组

//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划 
// 👍 1121 👎 0


package cn.com.meguru.leetcode.editor.cn;

import cn.com.meguru.helper.Helper;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        MaximumProductSubarray mainClass = new MaximumProductSubarray();
        Solution solution = mainClass.new Solution();
        solution.maxProduct(Helper.toArray2("[-1,-2,-9,-6]"));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProduct(int[] nums) {
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        max[0] = nums[0];
        min[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int maxnum = Math.max(Math.max(max[i - 1] * nums[i], min[i - 1] * nums[i]), nums[i]);
            max[i] = maxnum;
            int minnum = Math.min(Math.min(max[i - 1] * nums[i], min[i - 1] * nums[i]), nums[i]);
            min[i] = minnum;
        }
        int result = nums[0];
        for (int i : max) {
            if (i > result) {
                result = i;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}