//丑数 II

//给你一个整数 n ，请你找出并返回第 n 个 丑数 。 
//
// 丑数 就是只包含质因数 2、3 和/或 5 的正整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 10
//输出：12
//解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
//解释：1 通常被视为丑数。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 1690 
// 
// Related Topics 哈希表 数学 动态规划 堆（优先队列） 
// 👍 680 👎 0


package cn.com.meguru.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class UglyNumberIi {
    public static void main(String[] args) {
        UglyNumberIi mainClass = new UglyNumberIi();
        Solution solution = mainClass.new Solution();
        solution.nthUglyNumber(10);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int nthUglyNumber(int n) {
        m = new int[n];
        m[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        for (int i = 1; i < n; i++) {
            int u2 = m[i2] * 2;
            int u3 = m[i3] * 3;
            int u5 = m[i5] * 5;
            m[i] = Math.min(u2, Math.min(u3, u5));
            if (m[i] == u2) {
                i2 = i2 + 1;
            }
            if (m[i] == u3) {
                i3 = i3 + 1;
            }
            if (m[i] == u5) {
                i5 = i5 + 1;
            }
        }
        return m[n - 1];
    }

    int[] m = null;
    //超时
    public int nthUglyNumber1(int n) {
        int res = 0, count = 0;
        for (int i = 1; count < n; i++) {
            if (isUgly(i)) {
                count = count + 1;
                res = i;
            }
        }
        return res;
    }

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