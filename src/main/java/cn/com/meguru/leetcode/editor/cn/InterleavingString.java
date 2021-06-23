//交错字符串

//给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。 
//
// 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串： 
//
// 
// s = s1 + s2 + ... + sn 
// t = t1 + t2 + ... + tm 
// |n - m| <= 1 
// 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ... 
// 
//
// 提示：a + b 意味着字符串 a 和 b 连接。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：s1 = "", s2 = "", s3 = ""
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s1.length, s2.length <= 100 
// 0 <= s3.length <= 200 
// s1、s2、和 s3 都由小写英文字母组成 
// 
// Related Topics 字符串 动态规划 
// 👍 471 👎 0


package cn.com.meguru.leetcode.editor.cn;

import java.util.Objects;

public class InterleavingString {
    public static void main(String[] args) {
        InterleavingString mainClass = new InterleavingString();
        Solution solution = mainClass.new Solution();
        solution.isInterleave("aabcc", "dbbca", "aadbbcbcac");
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s1.isEmpty()) {
            return Objects.equals(s2, s3);
        }
        if (s2 == null || s2.isEmpty()) {
            return Objects.equals(s1, s3);
        }
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        Boolean[][][] memo = new Boolean[s1.length()][s2.length()][s3.length()];
        return isInterleave(s1.length() - 1, s2.length() - 1, s3.length() - 1, s1, s2, s3, memo);

    }

    private boolean isInterleave(int idxs1, int idxs2, int idxs3, String s1, String s2, String s3, Boolean[][][] memo) {
        if (idxs3 == -1) {
            return true;
        }
        if (idxs1 == -1) {
            return Objects.equals(s2.substring(0, idxs2 + 1), s3.substring(0, idxs3 + 1));
        }
        if (idxs2 == -1) {
            return Objects.equals(s1.substring(0, idxs1 + 1), s3.substring(0, idxs3 + 1));
        }
        if (memo[idxs1][idxs2][idxs3] == null) {
            memo[idxs1][idxs2][idxs3] = (s1.charAt(idxs1) == s3.charAt(idxs3) && isInterleave(idxs1 - 1, idxs2, idxs3 - 1, s1, s2, s3, memo))
                    || (s2.charAt(idxs2) == s3.charAt(idxs3) && isInterleave(idxs1, idxs2 - 1, idxs3 - 1, s1, s2, s3, memo));
        }
        return memo[idxs1][idxs2][idxs3];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}