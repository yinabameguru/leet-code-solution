//单词拆分

//给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。 
//
// 说明： 
//
// 
// 拆分时可以重复使用字典中的单词。 
// 你可以假设字典中没有重复的单词。 
// 
//
// 示例 1： 
//
// 输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
// 
//
// 示例 2： 
//
// 输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
//     注意你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
// 
// Related Topics 动态规划 
// 👍 1000 👎 0


package cn.com.meguru.leetcode.editor.cn;

import java.util.*;

public class WordBreak {
    public static void main(String[] args) {
        WordBreak mainClass = new WordBreak();
        Solution solution = mainClass.new Solution();
        List<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        solution.wordBreak("leetcode", list);
//        list.add("aaaaaaaaaa");
//        list.add("aaaaaaaaa");
//        list.add("aaaaaaaa");
//        list.add("aaaaaaa");
//        list.add("aaaaaa");
//        list.add("aaaaa");
//        list.add("aaaa");
//        list.add("aaa");
//        list.add("aa");
//        list.add("a");
//        solution.wordBreak("aaaaaaaab", list);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {


    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()];
        Set<String> set = new HashSet<>(wordDict);
        for (int i = 1; i < dp.length + 1; i++) {
            for (int j = 0; j < i; j++) {
                String right = s.substring(j, i);
                if ((j == 0 || dp[j - 1]) && (set.contains(right))) {
                    dp[i - 1] = true;
                    break;
                }
            }
        }
        return dp[dp.length - 1];
    }

    Map<String, Boolean> map = new HashMap<>();

    Set<String> set = null;

    //遍历加缓存
    public boolean wordBreak2(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        boolean result = union(s, 0, s.length() - 1);
        return result;
    }

    private boolean union(String s, int start, int end) {
        if (start > end) {
            return true;
        }
        for (int i = start + 1; i <= end + 1; i++) {
            String left = s.substring(start, i);
            String right = s.substring(i);
            boolean contains = set.contains(left);
            if (!contains) {
                map.put(left, false);
                continue;
            }
            if (Objects.equals(map.get(right), false)) {
                continue;
            }
            map.put(left, true);
            map.put(s.substring(0, i), true);
            Boolean b = map.get(right);
            if (Objects.isNull(b)) {
                if (union(s, i, end)) {
                    return true;
                }
            } else {
                if (b) {
                    return true;
                } else {
                    map.put(right, false);
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}