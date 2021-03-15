//搜索旋转排序数组

//整数数组 nums 按升序排列，数组中的值 互不相同 。 
//
// 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[
//k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2
//,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。 
//
// 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的索引，否则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 0
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：nums = [1], target = 0
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// -10^4 <= nums[i] <= 10^4 
// nums 中的每个值都 独一无二 
// nums 肯定会在某个点上旋转 
// -10^4 <= target <= 10^4 
// 
//
// 
//
// 进阶：你可以设计一个时间复杂度为 O(log n) 的解决方案吗？ 
// Related Topics 数组 二分查找 
// 👍 1217 👎 0


package cn.com.meguru.leetcode.editor.cn;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        SearchInRotatedSortedArray mainClass = new SearchInRotatedSortedArray();
        Solution solution = mainClass.new Solution();
//        solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0);
        solution.search(new int[]{1, 3}, 3);
//        solution.search(new int[]{5,1,3}, 5);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            return search(nums, target, 0, nums.length - 1);
        }

        public int search(int[] nums, int target, int left, int right) {
            if (left == -1 || right == nums.length || right < left) {
                return -1;
            }
            if (left == right) {
                return target == nums[left] ? left : -1;
            }

            int mid = (left + right) / 2;
            int midVal = nums[mid], leftVal = nums[left], rightVal = nums[right];
            if (target == midVal) {
                return mid;
            }
            //尼玛什么垃圾
            return leftVal <= midVal ?
                    target < midVal ?
                            target < leftVal ?
                                    search(nums, target, mid + 1, right) :
                                    search(nums, target, left, mid - 1) :
                            search(nums, target, mid + 1, right) :
                    target < midVal ?
                            search(nums, target, left, mid - 1) :
                            target < leftVal ?
                                    search(nums, target, mid + 1, right) :
                                    search(nums, target, left, mid - 1);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}