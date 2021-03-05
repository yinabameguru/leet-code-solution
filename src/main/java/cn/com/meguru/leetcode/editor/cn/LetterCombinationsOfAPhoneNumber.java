//电话号码的字母组合

//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 深度优先搜索 递归 字符串 回溯算法 
// 👍 1161 👎 0


package cn.com.meguru.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber mainClass = new LetterCombinationsOfAPhoneNumber();
        Solution solution = mainClass.new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private final Map<Character, char[]> map = new HashMap();

        public List<String> letterCombinations(String digits) {
            if (digits.length() == 0) {
                return new ArrayList<>();
            }
            initMap();
            List<String> res = new ArrayList<>();
            letterCombinations(digits, "", 0, res);
            return res;
        }

        private void letterCombinations(String digits, String s, int index, List<String> res) {
            char[] chars = map.get(digits.charAt(index));

            if (index == digits.length() - 1) {
                for (char c : chars) {
                    res.add(s + c);
                }
                return;
            }

            for (char c : chars) {
                letterCombinations(digits, s + c, index + 1, res);

            }

        }

        private char[] mapToChar(Integer num) {
            return map.get(num);
        }

        private void initMap() {
            map.put('2', new char[]{'a', 'b', 'c'});
            map.put('3', new char[]{'d', 'e', 'f'});
            map.put('4', new char[]{'g', 'h', 'i'});
            map.put('5', new char[]{'j', 'k', 'l'});
            map.put('6', new char[]{'m', 'n', 'o'});
            map.put('7', new char[]{'p', 'q', 'r', 's'});
            map.put('8', new char[]{'t', 'u', 'v'});
            map.put('9', new char[]{'w', 'x', 'y', 'z'});
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}