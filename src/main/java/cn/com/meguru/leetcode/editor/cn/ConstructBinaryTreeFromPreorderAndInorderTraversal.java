//从前序与中序遍历序列构造二叉树

//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组 
// 👍 1051 👎 0


package cn.com.meguru.leetcode.editor.cn;

import cn.com.meguru.helper.TreeNode;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        ConstructBinaryTreeFromPreorderAndInorderTraversal mainClass = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
        Solution solution = mainClass.new Solution();
        solution.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        TreeNode root = build(preorder, inorder, 0, preorder.length - 1, 0, preorder.length - 1);

        return root;
    }

    private TreeNode build(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        TreeNode root = new TreeNode(preorder[preLeft]);
        if (preLeft == preRight) {
            return root;
        }
        int inorderIdx = 0, preorderIdx = preLeft;
        for (int i = inLeft; i <= inRight; i++) {
            if (preorder[preorderIdx] == inorder[i]) {
                inorderIdx = i;
                break;
            }
        }
        if (preorderIdx + 1 <= preRight && preorderIdx + (inorderIdx - inLeft) <= preRight && inorderIdx - 1 >= inLeft) {
            root.left = build(preorder, inorder, preorderIdx + 1, preorderIdx + (inorderIdx - inLeft), inLeft, inorderIdx  - 1);
        }

        if (preorderIdx + (inorderIdx - inLeft) + 1 <= preRight && inorderIdx + 1 <= inRight) {
            root.right = build(preorder, inorder, preorderIdx + (inorderIdx - inLeft) + 1, preRight, inorderIdx + 1, inRight);
        }
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}