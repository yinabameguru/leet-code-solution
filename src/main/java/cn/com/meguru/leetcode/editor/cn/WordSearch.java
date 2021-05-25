//单词搜索

//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SE
//E"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CB"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 
// Related Topics 数组 回溯算法 
// 👍 908 👎 0


package cn.com.meguru.leetcode.editor.cn;

public class WordSearch {
    public static void main(String[] args) {
        WordSearch mainClass = new WordSearch();
        Solution solution = mainClass.new Solution();
        solution.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED");
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean exist(char[][] board, String word) {
        int[][] mark = new int[board.length][board[0].length];
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[0].length; x++) {
                boolean b = exist(board, word, y, x, 0, mark);
                if (b) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, String word, int y, int x, int idx, int[][] mark) {
        if (board[y][x] != word.charAt(idx)) {
            return false;
        }
        if (mark[y][x] != 0) {
            return false;
        }
        mark[y][x] = 1;
        if (idx == word.length() - 1) {
            return true;
        }
        boolean b = false;
        if (y - 1 >= 0) {
            b = exist(board, word, y - 1, x, idx + 1, mark);
        }
        if (!b && y + 1 <= board.length - 1) {
            b = exist(board, word, y + 1, x, idx + 1, mark);
        }
        if (!b && x - 1 >= 0) {
            b = exist(board, word, y, x - 1, idx + 1, mark);
        }
        if (!b && x + 1 <= board[0].length - 1) {
            b = exist(board, word, y, x + 1, idx + 1, mark);
        }
        mark[y][x] = 0;
        return b;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}