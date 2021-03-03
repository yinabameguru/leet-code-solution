//最长回文子串

//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 3225 👎 0


package cn.com.meguru.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        LongestPalindromicSubstring mainClass = new LongestPalindromicSubstring();
        Solution solution = mainClass.new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {

            if (s.length() == 1) {
                return s;
            }
            if (s.length() == 2) {
                if (s.charAt(0) == s.charAt(1)) {
                    return s;
                } else {
                    return String.valueOf(s.charAt(0));
                }
            }

            int start = 0, end = s.length() - 1;

            List<String> palindromes = new ArrayList<String>();

            char[] chars = s.toCharArray();

            for (int i = 0; i < chars.length; i++) {
                List<String> localOddPalindromes = new ArrayList<String>();
                dp(s, localOddPalindromes, i, i);
                if (localOddPalindromes.size() > 0) {
                    palindromes.add(localOddPalindromes.get(localOddPalindromes.size() - 1));
                }
                List<String> localEvenPalindromes = new ArrayList<String>();
                dp(s, localEvenPalindromes, i, i + 1);
                if (localEvenPalindromes.size() > 0) {
                    palindromes.add(localEvenPalindromes.get(localEvenPalindromes.size() - 1));
                }
            }

            String res = "";

            for (String palindrome : palindromes) {
                if (palindrome.length() > res.length()) {
                    res = palindrome;
                }
            }

            return res;
        }

        private void dp(String s, List<String> palindromes, int start, int end) {
            if (start < 0 || end > s.length() - 1) {
                return;
            }
            if (start == end) {
                palindromes.add(String.valueOf(s.charAt(start)));
                dp(s, palindromes, start - 1, end + 1);
                return;
            }

            if (s.charAt(start) == s.charAt(end)) {
                palindromes.add(s.substring(start, end + 1));
                dp(s, palindromes, start - 1, end + 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}