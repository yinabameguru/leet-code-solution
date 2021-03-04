//三数之和

//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 
// 👍 3034 👎 0


package cn.com.meguru.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        ThreeSum mainClass = new ThreeSum();
        Solution solution = mainClass.new Solution();
        solution.threeSum(new int[]{-29, -29, -14, -11, -6, -3, -3, 1, 2, 10, 12, 13, 15, 15, 17});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            if (nums.length < 3) {
                return new ArrayList<>();
            }
            List<List<Integer>> res = new ArrayList<>();

            nums = Arrays.stream(nums).sorted().toArray();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0 || i + 2 == nums.length) {
                    break;
                }
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int num1 = nums[i], left = i + 1, right = nums.length - 1;
                while (left < right) {
                    int sum = num1 + nums[left] + nums[right];
                    if (sum == 0) {
                        ArrayList<Integer> treeSum = new ArrayList<>();
                        treeSum.add(num1);
                        treeSum.add(nums[left]);
                        treeSum.add(nums[right]);
                        do {
                            left = left + 1;
                        } while (left < nums.length && nums[left] == nums[left - 1]);
                        res.add(treeSum);
                    } else if (sum > 0) {
                        right = right - 1;
                    } else {
                        left = left + 1;
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}