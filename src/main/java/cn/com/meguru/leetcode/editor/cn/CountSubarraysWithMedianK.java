//统计中位数为 K 的子数组

//给你一个长度为 n 的数组 nums ，该数组由从 1 到 n 的 不同 整数组成。另给你一个正整数 k 。 
//
// 统计并返回 nums 中的 中位数 等于 k 的非空子数组的数目。 
//
// 注意： 
//
// 
// 数组的中位数是按 递增 顺序排列后位于 中间 的那个元素，如果数组长度为偶数，则中位数是位于中间靠 左 的那个元素。 
// 
//
// 
// 例如，[2,3,1,4] 的中位数是 2 ，[8,4,3,5,1] 的中位数是 4 。 
// 
// 
// 子数组是数组中的一个连续部分。 
//
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,2,1,4,5], k = 4
//输出：3
//解释：中位数等于 4 的子数组有：[4]、[4,5] 和 [1,4,5] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,3,1], k = 3
//输出：1
//解释：[3] 是唯一一个中位数等于 3 的子数组。
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 10⁵ 
// 1 <= nums[i], k <= n 
// nums 中的整数互不相同 
// 
//
// Related Topics 数组 哈希表 前缀和 👍 145 👎 0


package cn.com.meguru.leetcode.editor.cn;

import cn.com.meguru.helper.Helper;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class CountSubarraysWithMedianK {
    public static void main(String[] args) {
        CountSubarraysWithMedianK mainClass = new CountSubarraysWithMedianK();
        Solution solution = mainClass.new Solution();
        int[] ints = new int[100000];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = i;
        }
//        solution.countSubarrays(ints, 38699);
        solution.countSubarrays(Helper.toArray2("[5,19,11,15,13,16,4,6,2,7,10,8,18,20,1,3,17,9,12,14]"),
                6);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countSubarrays(int[] nums, int k) {
        long start = System.currentTimeMillis();
        int idxk = 0, res = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == k) {
                idxk = i;
                nums[i] = 0;
                continue;
            }
            nums[i] = nums[i] > k ? 1 : -1;
        }

        Map<Integer, Integer> rightMap = new HashMap<>();
        Map<Integer, Integer> leftMap = new HashMap<>();
        for (int i = idxk; i < nums.length; i++) {
            sum = sum + nums[i];
            rightMap.put(sum, rightMap.getOrDefault(sum, 0) + 1);
        }
        sum = 0;
        for (int j = idxk - 1; j >= 0; j--) {
            sum = sum + nums[j];
            leftMap.put(sum, leftMap.getOrDefault(sum, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : rightMap.entrySet()) {
            Integer key = entry.getKey();
            Integer val = entry.getValue();
            if (key == 0 || key == 1) {
                res = res + val;
            }
            res = res + leftMap.getOrDefault(-key, 0) * val + leftMap.getOrDefault(1 - key, 0) * val;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}