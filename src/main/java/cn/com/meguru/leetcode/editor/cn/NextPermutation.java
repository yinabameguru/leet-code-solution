//下一个排列

//实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。 
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。 
//
// 必须 原地 修改，只允许使用额外常数空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[1,2,3]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,5]
//输出：[1,5,1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
// Related Topics 数组 
// 👍 987 👎 0


package cn.com.meguru.leetcode.editor.cn;

public class NextPermutation {
    public static void main(String[] args) {
        NextPermutation mainClass = new NextPermutation();
        Solution solution = mainClass.new Solution();
        solution.nextPermutation(new int[]{2, 3, 1, 3, 3});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void nextPermutation(int[] nums) {
            for (int i = nums.length - 1; i > 0; i--) {
                if (nums[i] > nums[i - 1]) {
                    int left = i - 1, right = i;
                    for (int j = nums.length - 1; j >= i; j--) {
                        if (nums[j] > nums[left] && nums[j] <= nums[right]) {
                            right = j;
                            break;
                        }
                    }
                    swapInt(nums, left, right);
                    left = left + 1;
                    right = nums.length - 1;
                    while (left < right) {
                        swapInt(nums, left, right);
                        left = left + 1;
                        right = right - 1;
                    }
                    return;
                }
            }
            int left = 0, right = nums.length - 1;
            while (left < right) {
                swapInt(nums, left, right);
                left = left + 1;
                right = right - 1;
            }
        }

        public void swapInt(int[] nums, int i, int j) {
            int c = nums[i];
            nums[i] = nums[j];
            nums[j] = c;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}