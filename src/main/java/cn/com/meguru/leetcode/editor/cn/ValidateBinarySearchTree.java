//验证二叉搜索树

//给定一个二叉树，判断其是否是一个有效的二叉搜索树。 
//
// 假设一个二叉搜索树具有如下特征： 
//
// 
// 节点的左子树只包含小于当前节点的数。 
// 节点的右子树只包含大于当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 示例 1: 
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
// 
// Related Topics 树 深度优先搜索 递归 
// 👍 1071 👎 0


package cn.com.meguru.leetcode.editor.cn;

import cn.com.meguru.helper.TreeNode;

public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        ValidateBinarySearchTree mainClass = new ValidateBinarySearchTree();
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
    private long val = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = isValidBST(root.left);
        if (!left) {
            return false;
        }
        if (!(val < root.val)) {
            return false;
        }
        val = root.val;
        boolean right = isValidBST(root.right);
        return right;
    }

//    public boolean isValidBST(TreeNode root) {
//        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
//    }

    //分治
    public boolean isValidBST(TreeNode root, Long min, Long max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return isValidBST(root.left, min, (long) root.val) && isValidBST(root.right, (long) root.val, max);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}