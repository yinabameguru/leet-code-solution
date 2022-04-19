//把二叉搜索树转换为累加树

//给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于
// node.val 的值之和。 
//
// 提醒一下，二叉搜索树满足下列约束条件： 
//
// 
// 节点的左子树仅包含键 小于 节点键的节点。 
// 节点的右子树仅包含键 大于 节点键的节点。 
// 左右子树也必须是二叉搜索树。 
// 
//
// 注意：本题和 1038: https://leetcode-cn.com/problems/binary-search-tree-to-greater-
//sum-tree/ 相同 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
//输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
// 
//
// 示例 2： 
//
// 输入：root = [0,null,1]
//输出：[1,null,1]
// 
//
// 示例 3： 
//
// 输入：root = [1,0,2]
//输出：[3,3,2]
// 
//
// 示例 4： 
//
// 输入：root = [3,2,4,1]
//输出：[7,9,4,10]
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数介于 0 和 10⁴ 之间。 
// 每个节点的值介于 -10⁴ 和 10⁴ 之间。 
// 树中的所有值 互不相同 。 
// 给定的树为二叉搜索树。 
// 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 703 👎 0


package cn.com.meguru.leetcode.editor.cn;

import cn.com.meguru.helper.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConvertBstToGreaterTree {
    public static void main(String[] args) {
        ConvertBstToGreaterTree mainClass = new ConvertBstToGreaterTree();
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
    public TreeNode convertBST(TreeNode root) {
        TreeNode f1res = f1(root);
        return f1res;
    }

    /**
     * 1 先把二叉搜索树按中序遍历序列化到数组
     * 2 从大到小遍历数组，计算累加值
     * 3 再中序遍历二叉搜索树，替换累加后的值
     * @param root
     * @return
     */
    private TreeNode f1(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        List<Integer> list = new ArrayList<>();
        midRootForeach(root, r -> list.add(r.val));
        for (int i = list.size() - 2; i >= 0; i--) {
            list.set(i, list.get(i) + list.get(i + 1));
        }
        //表达式里不能改变int值，用数组代替
        final Integer[] i = {0};
        midRootForeach(root, r -> {
            r.val = list.get(i[0]);
            i[0] = i[0] + 1;
        });
        return root;
    }

    //cn.com.meguru.helper.Helper.midRootForeach
    public void midRootForeach(TreeNode root, Consumer<TreeNode> consumer) {
        if (root == null) {
            return;
        }
        midRootForeach(root.left, consumer);
        consumer.accept(root);
        midRootForeach(root.right, consumer);
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}