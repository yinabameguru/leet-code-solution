//分割等和子集

//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
// Related Topics 数组 动态规划 
// 👍 896 👎 0


package cn.com.meguru.leetcode.editor.cn;

import cn.com.meguru.helper.Helper;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        PartitionEqualSubsetSum mainClass = new PartitionEqualSubsetSum();
        Solution solution = mainClass.new Solution();
        solution.canPartition(Helper.toArray2("[1,2,3,5]"));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        Set<Integer> set = new HashSet<>();
        set.add(0);
        for (int num : nums) {
            Set<Integer> temp = new HashSet<>();
            for (Integer integer : set) {
                int curNum = integer + num;
                if (curNum == target) {
                    return true;
                }
                if (curNum > target) {
                    continue;
                }
                temp.add(curNum);
            }
            set.addAll(temp);
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}