//字符串的排列

//输入一个字符串，打印出该字符串中字符的所有排列。 
//
// 
//
// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。 
//
// 
//
// 示例: 
//
// 输入：s = "abc"
//输出：["abc","acb","bac","bca","cab","cba"]
// 
//
// 
//
// 限制： 
//
// 1 <= s 的长度 <= 8 
// Related Topics 回溯算法 
// 👍 184 👎 0


package cn.com.meguru.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ZiFuChuanDePaiLieLcof {
    public static void main(String[] args) {
        ZiFuChuanDePaiLieLcof mainClass = new ZiFuChuanDePaiLieLcof();
        Solution solution = mainClass.new Solution();
        solution.permutation("abc");
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String[] permutation(String s) {
        if (s.length() == 0) {
            return new String[0];
        }
        char[] chars = s.toCharArray();
        Set<String> res = new HashSet<String>();
        permutation(chars, 0, res);
        return res.toArray(new String[0]);
    }

    private void permutation(char[] chars, int i, Set<String> res) {
        if (i == chars.length - 1) {
            res.add(String.copyValueOf(chars));
            return;
        }
        permutation(chars, i + 1, res);
        //剪枝
        HashSet<Character> set = new HashSet<>();
        set.add(chars[i]);
        for (int j = i + 1; j < chars.length; j++) {
            if (set.contains(chars[j])) {
                continue;
            }
            set.add(chars[j]);
            swap(chars, i, j);
            permutation(chars, i + 1, res);
            swap(chars, i, j);
        }
    }

    private void swap(char[] chars, int i, int j) {
        char c = chars[i];
        chars[i] = chars[j];
        chars[j] = c;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}