//找到字符串中所有字母异位词

//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。 
//
// 异位词 指字母相同，但排列不同的字符串。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
// 
//
// 示例 2: 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, p.length <= 3 * 10⁴ 
// s 和 p 仅包含小写字母 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 602 👎 0


package cn.com.meguru.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        FindAllAnagramsInAString mainClass = new FindAllAnagramsInAString();
        Solution solution = mainClass.new Solution();
        solution.findAnagrams("cbaebabacd", "abc");
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length()) {
            return res;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int count = p.length();

        char[] chars1 = p.toCharArray();
        for (int i = 0; i < chars1.length; i++) {
            if (map.get(chars1[i]) == null) {
                map.put(chars1[i], 1);
            } else {
                map.put(chars1[i], map.get(chars1[i]) + 1);
            }
        }
        int left = 0, right = -1;
        char[] chars = s.toCharArray();
        while (right < chars.length) {
            if (right - left < p.length() - 1) {
                right = right + 1;
                Integer val = map.get(chars[right]);
                if (val != null) {
                    if (val <= 0) {
                        map.put(chars[right], val - 1);
                    } else {
                        map.put(chars[right], val - 1);
                        count = count - 1;
                    }
                }
                if (count == 0) {
                    res.add(left);
                }
            }
            if (right - left == p.length() - 1) {
                char leftChar = chars[left];
                Integer leftVal = map.get(leftChar);
                if (leftVal != null) {
                    if (leftVal < 0) {
                        map.put(leftChar, leftVal + 1);
                    } else {
                        map.put(leftChar, leftVal + 1);
                        count = count + 1;
                    }
                }
                left = left + 1;
                right = right + 1;
                if (right == chars.length) {
                    break;
                }
                Integer val = map.get(chars[right]);
                if (val != null) {
                    if (val <= 0) {
                        map.put(chars[right], val - 1);
                    } else {
                        map.put(chars[right], val - 1);
                        count = count - 1;
                        if (count == 0) {
                            res.add(left);
                        }
                    }
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}