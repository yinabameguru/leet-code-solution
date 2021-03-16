//在排序数组中查找元素的第一个和最后一个位置

//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums 是一个非递减数组 
// -109 <= target <= 109 
// 
// Related Topics 数组 二分查找 
// 👍 898 👎 0


package cn.com.meguru.leetcode.editor.cn;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        FindFirstAndLastPositionOfElementInSortedArray mainClass = new FindFirstAndLastPositionOfElementInSortedArray();
        Solution solution = mainClass.new Solution();
//        solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        solution.searchRange(new int[]{1}, 1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private int[] res = new int[]{-1, -1};

        public int[] searchRange(int[] nums, int target) {
            searchTarget(nums, target, 0, nums.length - 1);
            return res;
        }

        private void searchTarget(int[] nums, int target, int left, int right) {
            if (right == -1 || left == nums.length) {
                return;
            }
            if (left == right) {
                if (target == nums[left]) {
                    res = new int[]{left, left};
                }
                return;
            }
            int mid = (left + right) / 2, midVal = nums[mid];
            if (midVal > target) {
                searchTarget(nums, target, left, mid - 1);
            }
            if (midVal < target) {
                searchTarget(nums, target, mid + 1, right);
            }
            if (midVal == target) {
                searchLeftRange(nums, left, mid);
                searchRightRange(nums, mid, right);
            }
        }

        private void searchRightRange(int[] nums, int left, int right) {
            if (left == right) {
                res[1] = right;
                return;
            }
            int mid = (left + right) / 2, midVal = nums[mid], leftVal = nums[left], rightVal = nums[right];
            if (midVal > leftVal) {
                searchRightRange(nums, left, mid - 1);
            } else {
                //midVal == leftVal
                if (mid == left) {
                    res[1] = rightVal == leftVal ? right : left;
                    return;
                }
                searchRightRange(nums, mid, right);
            }
        }

        private void searchLeftRange(int[] nums, int left, int right) {
            if (left == right) {
                res[0] = left;
                return;
            }
            int mid = (left + right) / 2, midVal = nums[mid], rightVal = nums[right];
            if (midVal < rightVal) {
                searchLeftRange(nums, mid + 1, right);
            } else {
                //midVal == rightVal
                searchLeftRange(nums, left, mid);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}