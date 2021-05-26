//对称二叉树

//给定一个二叉树，检查它是否是镜像对称的。 
//
// 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 
//
// 进阶： 
//
// 你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 1395 👎 0


package cn.com.meguru.leetcode.editor.cn;

import cn.com.meguru.helper.TreeNode;

import java.util.Objects;

import static cn.com.meguru.helper.Helper.arrayToTree;

public class SymmetricTree {
    public static void main(String[] args) {
        SymmetricTree mainClass = new SymmetricTree();
        Solution solution = mainClass.new Solution();
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(2);
//        root.left.left = new TreeNode(3);
//        root.left.right = new TreeNode(4);
//        root.right.left = new TreeNode(4);
//        root.right.right = new TreeNode(3);
        TreeNode root = arrayToTree(new Integer[]{1, 2, 2, null, 3, null, 3});
        boolean symmetric = solution.isSymmetric(root);
        System.out.println(symmetric);
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
    public boolean isSymmetric(TreeNode root) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        it1(root, sb1);
        it2(root, sb2);
        return Objects.equals(sb1.toString(), sb2.toString());
    }

    private void it1(TreeNode root, StringBuilder sb1) {
        if (root == null) {
            sb1.append("n");
            return;
        }
        sb1.append(root.val);
        it1(root.left, sb1);
        it1(root.right, sb1);
    }
    private void it2(TreeNode root, StringBuilder sb2) {
        if (root == null) {
            sb2.append("n");
            return;
        }
        sb2.append(root.val);
        it2(root.right, sb2);
        it2(root.left, sb2);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}