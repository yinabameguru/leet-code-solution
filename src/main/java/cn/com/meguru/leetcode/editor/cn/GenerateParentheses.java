//括号生成

//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 回溯算法 
// 👍 1599 👎 0


package cn.com.meguru.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenerateParentheses {
    public static void main(String[] args) {
        GenerateParentheses mainClass = new GenerateParentheses();
        Solution solution = mainClass.new Solution();
        solution.generateParenthesis(4);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        Map<Integer, List<String>> data = new HashMap<>();

        //动态规划
        public List<String> generateParenthesis(int n) {
            if (n == 1) {
                List<String> parentheses = new ArrayList<String>();
                parentheses.add("()");
                return parentheses;
            }
            List<String> pre = generateParenthesis(n - 1);
            data.put(n - 1, pre);
            List<String> parentheses = new ArrayList<>();

            for (int i = 0; i <= n - 1; i++) {
                List<String> left = data.get(i), right = data.get(n - 1 - i);
                if (left == null) {
                    for (String r : right) {
                        parentheses.add("()" + r);
                    }
                    continue;
                }
                for (String l : left) {
                    String val = "(" + l + ")";
                    if (right == null) {
                        parentheses.add(val);
                        continue;
                    }
                    for (String r : right) {
                        parentheses.add(val + r);
                    }
                }
            }
            return parentheses;
        }

        //--------------------------------------------------------------------------------------------------------------
        //回溯
        public List<String> generateParenthesis1(int n) {
            List<String> res = new ArrayList<>();
            generateParenthesis(res, 0, 0, 0, n, new StringBuilder());
            return res;
        }

        private void generateParenthesis(List<String> res, int curPairCount, int curLeftCount, int curRightCount, int targetPairCount, StringBuilder sb) {
            if (curPairCount == targetPairCount) {
                res.add(sb.toString());
                return;
            }
            if (curLeftCount < targetPairCount) {
                sb.append("(");
                generateParenthesis(res, curPairCount, curLeftCount + 1, curRightCount, targetPairCount, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
            if (curRightCount < targetPairCount && curLeftCount > curRightCount) {
                sb.append(")");
                generateParenthesis(res, curPairCount + 1, curLeftCount, curRightCount + 1, targetPairCount, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}