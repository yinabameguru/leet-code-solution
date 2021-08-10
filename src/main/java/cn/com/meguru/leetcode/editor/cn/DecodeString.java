//字符串解码

//给定一个经过编码的字符串，返回它解码后的字符串。 
//
// 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。 
//
// 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。 
//
// 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。 
//
// 
//
// 示例 1： 
//
// 输入：s = "3[a]2[bc]"
//输出："aaabcbc"
// 
//
// 示例 2： 
//
// 输入：s = "3[a2[c]]"
//输出："accaccacc"
// 
//
// 示例 3： 
//
// 输入：s = "2[abc]3[cd]ef"
//输出："abcabccdcdcdef"
// 
//
// 示例 4： 
//
// 输入：s = "abc3[cd]xyz"
//输出："abccdcdcdxyz"
// 
// Related Topics 栈 递归 字符串 
// 👍 841 👎 0


package cn.com.meguru.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class DecodeString {
    public static void main(String[] args) {
        DecodeString mainClass = new DecodeString();
        Solution solution = mainClass.new Solution();
        solution.decodeString("3[a]2[bc]");
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String decodeString(String s) {
        Deque<Character> queue = new LinkedList<>();
        int idx = 0, end = s.length();
        StringBuilder res = new StringBuilder();
        while (idx < end) {
            char c = s.charAt(idx);
            if (c == ']') {
                String temp = "", timeString = "";
                Character pop = queue.removeLast();
                while (pop != '[') {
                    temp = pop + temp;
                    pop = queue.removeLast();
                }
                pop = queue.getLast();
                while (pop >= '0' && pop <= '9') {
                    timeString = pop + timeString;
                    queue.removeLast();
                    if (queue.isEmpty()) {
                        break;
                    }
                    pop = queue.getLast();
                }
                int time = Integer.parseInt(timeString);
                for (int i = 0; i < time; i++) {
                    for (int i1 = 0; i1 < temp.length(); i1++) {
                        queue.addLast(temp.charAt(i1));
                    }
                }
            } else {
                queue.addLast(c);
            }

            idx = idx + 1;
        }
        while (!queue.isEmpty()) {
            res.append(queue.removeFirst());
        }
        return res.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}