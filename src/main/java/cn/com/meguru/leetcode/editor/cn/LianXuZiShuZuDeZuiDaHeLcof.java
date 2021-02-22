//连续子数组的最大和

//输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。 
//
// 要求时间复杂度为O(n)。 
//
// 
//
// 示例1: 
//
// 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10^5 
// -100 <= arr[i] <= 100 
// 
//
// 注意：本题与主站 53 题相同：https://leetcode-cn.com/problems/maximum-subarray/ 
//
// 
// Related Topics 分治算法 动态规划 
// 👍 204 👎 0


package cn.com.meguru.leetcode.editor.cn;

public class LianXuZiShuZuDeZuiDaHeLcof {
    public static void main(String[] args) {
        LianXuZiShuZuDeZuiDaHeLcof mainClass = new LianXuZiShuZuDeZuiDaHeLcof();
        Solution solution = mainClass.new Solution();
        solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            int res = nums[0], curSum = nums[0];
            if (nums.length == 1) {
                return res;
            }
//        for (int i = 1; i < nums.length; i++) {
//            int curNum = nums[i];
//            int nextSun = curSum + curNum;
//            if (curNum > nextSun) {
//                curSum = curNum;
//            } else {
//                curSum = nextSun;
//            }
//            if (curSum > res) {
//                res = curSum;
//            }
//        }
            for (int i = 1; i < nums.length; i++) {
                int curNum = nums[i];
                int nextSun = curSum + curNum;

                if (curSum < 0) {
                    curSum = curNum;
                } else {
                    curSum = nextSun;
                }
                if (curSum > res) {
                    res = curSum;
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}