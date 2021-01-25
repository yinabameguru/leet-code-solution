//从上到下打印二叉树 III

//请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。 
//
// 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
// Related Topics 树 广度优先搜索 
// 👍 68 👎 0

package cn.com.meguru.leetcode.editor.cn;

import cn.com.meguru.helper.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class CongShangDaoXiaDaYinErChaShuIiiLcof {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        order(result, root, 1);
        return result;
    }

    private void order(List<List<Integer>> result, TreeNode node, int level) {
        if (result.size() < level)
            result.add(new ArrayList<>());
        if (level % 2 == 1)
            result.get(level - 1).add(node.val);
        else
            result.get(level - 1).add(0, node.val);

        if (node.left != null)
            order(result, node.left, level + 1);
        if (node.right != null)
            order(result, node.right, level + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
