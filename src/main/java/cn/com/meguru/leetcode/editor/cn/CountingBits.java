//比特位计数

//给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。 
//
// 示例 1: 
//
// 输入: 2
//输出: [0,1,1] 
//
// 示例 2: 
//
// 输入: 5
//输出: [0,1,1,2,1,2] 
//
// 进阶: 
//
// 
// 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？ 
// 要求算法的空间复杂度为O(n)。 
// 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。 
// 
// Related Topics 位运算 动态规划 
// 👍 779 👎 0


package cn.com.meguru.leetcode.editor.cn;

public class CountingBits {
    public static void main(String[] args) {
        CountingBits mainClass = new CountingBits();
        Solution solution = mainClass.new Solution();
        solution.countBits(5);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int[] countBits(int n) {
        if (n == 0) {
            return new int[]{0};
        }
        if (n == 1) {
            return new int[]{0, 1};
        }
        int[] res = new int[n + 1];
        res[0] = 0;
        res[1] = 1;
        int m = n, power = 1;
        while (m > 1) {
            power = power * 2;
            m = m >> 1;
        }
        count(n, res, power);
        return res;
    }

    private void count(int n, int[] res, int power) {
        if (res[n] != 0) {
            return;
        }
        if (n == 0) {
            res[0] = 0;
            return;
        }
        if (n == 1) {
            res[1] = 1;
            return;
        }
        count(n - 1, res, power > n - 1 ? power >> 1 : power);
        res[n] = res[n - power] + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}