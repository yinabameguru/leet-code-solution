//丑数

//给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。 
//
// 丑数 就是只包含质因数 2、3 和/或 5 的正整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 6
//输出：true
//解释：6 = 2 × 3 
//
// 示例 2： 
//
// 
//输入：n = 8
//输出：true
//解释：8 = 2 × 2 × 2
// 
//
// 示例 3： 
//
// 
//输入：n = 14
//输出：false
//解释：14 不是丑数，因为它包含了另外一个质因数 7 。
// 
//
// 示例 4： 
//
// 
//输入：n = 1
//输出：true
//解释：1 通常被视为丑数。
// 
//
// 
//
// 提示： 
//
// 
// -231 <= n <= 231 - 1 
// 
// Related Topics 数学 
// 👍 263 👎 0


package cn.com.meguru.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class UglyNumber {
    public static void main(String[] args) {
        UglyNumber mainClass = new UglyNumber();
        Solution solution = mainClass.new Solution();
        solution.isUgly(-2);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isUgly(int n) {
        if (n == 0) {
            return false;
        }
        Boolean res = memo.get(n);
        if (res != null) {
            return res;
        }
        res = n % 2 == 0 && isUgly(n / 2) || n % 3 == 0 && isUgly(n / 3) || n % 5 == 0 && isUgly(n / 5);
        memo.put(n, res);
        return res;
    }

    Map<Integer, Boolean> memo = new HashMap<>();

    {
        memo.put(1, true);
        memo.put(2, true);
        memo.put(3, true);
        memo.put(5, true);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}