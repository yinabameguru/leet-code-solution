//分割回文串

//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。 
//
// 回文串 是正着读和反着读都一样的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：[["a"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
// Related Topics 深度优先搜索 动态规划 回溯算法 
// 👍 759 👎 0


package cn.com.meguru.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        PalindromePartitioning mainClass = new PalindromePartitioning();
        Solution solution = mainClass.new Solution();
        solution.partition("aab");
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    String s = null;
    Boolean[][] memo = null;
    List<List<String>> res = new ArrayList<>();
    List<String> item = new ArrayList<>();

    public List<List<String>> partition(String s) {
        this.s = s;
        this.memo = new Boolean[s.length()][s.length()];
        partition(0, s.length() - 1, 0);
        return res;
    }

    private void partition(int start, int end, int cur) {
        if (cur > end) {
            return;
        }
        if (!isPalindrome(start, cur)) {
            partition(start, end, cur + 1);
            return;
        }
        item.add(s.substring(start, cur + 1));
        partition(cur + 1, end, cur + 1);
        if (cur == end) {
            List<String> list = new ArrayList<>(item);
            res.add(list);
        }
        item.remove(item.size() - 1);
        if (cur < end) {
            partition(start, end, cur + 1);
        }
    }

    private Boolean isPalindrome(int left, int right) {
        if (right < left) {
            return true;
        }
        if (memo[left][right] == null) {
            memo[left][right] = s.charAt(left) == s.charAt(right) && isPalindrome(left + 1, right - 1);
        }
        return memo[left][right];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}