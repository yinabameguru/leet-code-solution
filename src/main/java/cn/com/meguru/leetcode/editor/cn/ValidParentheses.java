//有效的括号

//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 
// 👍 2208 👎 0


package cn.com.meguru.leetcode.editor.cn;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        ValidParentheses mainClass = new ValidParentheses();
        Solution solution = mainClass.new Solution();
        solution.isValid("[()]");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty() || c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                Character head = stack.pop();
                if (!pair(head, c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

        private boolean pair(char head, char c) {
            return (head == '(' && c == ')')
                    || (head == '[' && c == ']')
                    || (head == '{' && c == '}');
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}