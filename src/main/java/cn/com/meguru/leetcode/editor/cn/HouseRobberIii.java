//打家劫舍 III

//在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“
//房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。 
//
// 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。 
//
// 示例 1: 
//
// 输入: [3,2,3,null,3,null,1]
//
//     3
//    / \
//   2   3
//    \   \ 
//     3   1
//
//输出: 7 
//解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7. 
//
// 示例 2: 
//
// 输入: [3,4,5,1,3,null,1]
//
//     3
//    / \
//   4   5
//  / \   \ 
// 1   3   1
//
//输出: 9
//解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
// 
// Related Topics 树 深度优先搜索 动态规划 二叉树 
// 👍 883 👎 0


package cn.com.meguru.leetcode.editor.cn;

import cn.com.meguru.helper.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class HouseRobberIii {
    public static void main(String[] args) {
        HouseRobberIii mainClass = new HouseRobberIii();
        Solution solution = mainClass.new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    Map<String, Integer> memo = new HashMap<>();
    StringBuilder sb = new StringBuilder();
    public int rob(TreeNode root) {
        return rob(root, "");
    }

    private int rob(TreeNode root, String path) {
        Integer num = memo.get(path);
        if (num != null) {
            return num;
        }
        if (root == null) {
            memo.put(path, 0);
            return 0;
        }
        int r1 = rob(root.left, path + "0") + rob(root.right, path + "1");
        int r2 = root.val;
        if (root.left != null) {
            r2 = r2 + rob(root.left.left, path + "00") + rob(root.left.right, path + "01");
        }
        if (root.right != null) {
            r2 = r2 + rob(root.right.left, path + "10") + rob(root.right.right, path + "11");
        }
        memo.put(path, Math.max(r1, r2));
        return memo.get(path);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}