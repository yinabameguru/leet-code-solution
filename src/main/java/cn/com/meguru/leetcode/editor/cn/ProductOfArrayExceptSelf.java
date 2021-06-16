//除自身以外数组的乘积

//给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之
//外其余各元素的乘积。 
//
// 
//
// 示例: 
//
// 输入: [1,2,3,4]
//输出: [24,12,8,6] 
//
// 
//
// 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。 
//
// 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。 
//
// 进阶： 
//你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。） 
// Related Topics 数组 
// 👍 844 👎 0


package cn.com.meguru.leetcode.editor.cn;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        ProductOfArrayExceptSelf mainClass = new ProductOfArrayExceptSelf();
        Solution solution = mainClass.new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    //通过记录数组中该数左边的乘积和该数右边的乘积来计算
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length], right = new int[nums.length], res = new int[nums.length];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < res.length; i++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }

    //全部相乘再除当前位置的数
    public int[] productExceptSelf1(int[] nums) {
        int all = 1, notZero = 1, zeroNum = 0;
        int[] res = new int[nums.length];

        for (int num : nums) {
            if (num == 0) {
                zeroNum = zeroNum + 1;
            } else {
                notZero = notZero * num;
            }
            all = all * num;
        }

        if (zeroNum > 1) {
            return res;
        }
        if (zeroNum == 1) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    res[i] = notZero;
                    return res;
                }
            }
        }

        for (int i = 0; i < res.length; i++) {
            res[i] = all / nums[i];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}