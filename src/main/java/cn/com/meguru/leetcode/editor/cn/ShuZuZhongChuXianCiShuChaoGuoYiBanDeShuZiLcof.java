//数组中出现次数超过一半的数字

//数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。 
//
// 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1: 
//
// 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
//输出: 2 
//
// 
//
// 限制： 
//
// 1 <= 数组长度 <= 50000 
//
// 
//
// 注意：本题与主站 169 题相同：https://leetcode-cn.com/problems/majority-element/ 
//
// 
// Related Topics 位运算 分治算法 
// 👍 112 👎 0


package cn.com.meguru.leetcode.editor.cn;

public class ShuZuZhongChuXianCiShuChaoGuoYiBanDeShuZiLcof {
    public static void main(String[] args) {
        ShuZuZhongChuXianCiShuChaoGuoYiBanDeShuZiLcof mainClass = new ShuZuZhongChuXianCiShuChaoGuoYiBanDeShuZiLcof();
        Solution solution = mainClass.new Solution();
        solution.majorityElement(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int majorityElement(int[] nums) {
            return majorityElement(nums, 0, nums.length - 1);
        }

        private int majorityElement(int[] nums, int workStart, int workEnd) {

            int index = partition(nums, workStart, workEnd);

            if (index == nums.length / 2) {
                return nums[index];
            } else if (index > nums.length / 2) {
                return majorityElement(nums, workStart, index - 1);
            } else {
                return majorityElement(nums, index + 1, workEnd);
            }

        }

        private int partition(int[] nums, int workStart, int workEnd) {
            if (workStart == workEnd) {
                return workStart;
            }
            int next = workStart + 1;
            if (nums[workStart] <= nums[next]) {
                swapInt(nums, next, workEnd);
                workEnd = workEnd - 1;
            } else {
                swapInt(nums, workStart, next);
                workStart = workStart + 1;
            }
            return partition(nums, workStart, workEnd);
        }

        public void swapInt(int[] nums, int i, int j) {
            int c = nums[i];
            nums[i] = nums[j];
            nums[j] = c;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

    /**
     * 摩尔投票法
     */
    public int majorityElement1(int[] nums) {
        int curNum = nums[0], count = 0;

        for (int num : nums) {
            if (num == curNum) {
                count = count + 1;
            } else if (count == 0) {
                curNum = num;
                count = count + 1;
            } else {
                count = count - 1;
            }
        }
        return curNum;
    }
}