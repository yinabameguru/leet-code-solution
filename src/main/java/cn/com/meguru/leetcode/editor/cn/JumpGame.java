//跳跃游戏

//给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 判断你是否能够到达最后一个下标。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,1,1,4]
//输出：true
//解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1,0,4]
//输出：false
//解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 104 
// 0 <= nums[i] <= 105 
// 
// Related Topics 贪心算法 数组 
// 👍 1188 👎 0


package cn.com.meguru.leetcode.editor.cn;

public class JumpGame {
    public static void main(String[] args) {
        JumpGame mainClass = new JumpGame();
        Solution solution = mainClass.new Solution();
        boolean result = solution.canJump(new int[]{0});
        System.out.println(result);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canJump(int[] nums) {

        int end = nums.length - 1, step = 0;

        for (int i = 0; i <= end; i++) {
            if (i > step) {
                return false;
            }
            step = Math.max(step, i + nums[i]);
            if (step >= end) {
                return true;
            }
        }
        return false;
    }

    //超时了
    private boolean canJump(int[] nums, int i) {
        if (i > nums.length - 1) {
            return false;
        }
        if (i == nums.length - 1) {
            return true;
        }
        int step = nums[i];

        if (step == 0) {
            return false;
        }

        for (int j = i + 1; (j <= i + step) && (j <= nums.length - 1); j++) {
            if (canJump(nums, j)) {
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}