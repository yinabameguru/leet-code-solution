//路径总和 III

//给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。 
//
// 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
//输出：3
//解释：和等于 8 的路径有 3 条，如图所示。
// 
//
// 示例 2： 
//
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：3
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [0,1000] 
// -109 <= Node.val <= 109 
// -1000 <= targetSum <= 1000 
// 
// Related Topics 树 深度优先搜索 二叉树 
// 👍 942 👎 0


package cn.com.meguru.leetcode.editor.cn;

import cn.com.meguru.helper.Helper;
import cn.com.meguru.helper.TreeNode;

import java.util.*;

public class PathSumIii {
    public static void main(String[] args) {
        PathSumIii mainClass = new PathSumIii();
        Solution solution = mainClass.new Solution();
        int i = solution.pathSum(Helper.arrayToTree(new Integer[]{1,0,1,2}), 2);
        System.out.println(i);
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
    public int pathSum(TreeNode root, int targetSum) {
        ArrayList<Integer> list = new ArrayList<>();
        return pathSum(root, targetSum, list);
    }

    private int pathSum(TreeNode root, int targetSum, ArrayList<Integer> list) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        if (root.val == targetSum) {
            res = res + 1;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Integer preval = list.get(i);
            if (preval + root.val == targetSum) {
                res = res + 1;
            }
        }
        for (int i = 0; i < size; i++) {
            list.set(i, list.get(i) + root.val);
        }
        list.add(root.val);
        res = res + pathSum(root.left, targetSum, list);
        res = res + pathSum(root.right, targetSum, list);
        list.remove(list.size() - 1);
        for (int i = 0; i < size; i++) {
            list.set(i, list.get(i) - root.val);
        }
        return res;
    }
//    public int pathSum(TreeNode root, int targetSum) {
//        Map<TreeNode, Integer> prefixMap = new HashMap<>();
//        buildMap(prefixMap, root, 0);
//        return pathSum(root, targetSum, prefixMap, new LinkedList<TreeNode>());
//    }
//
//    private int pathSum(TreeNode root, int targetSum, Map<TreeNode, Integer> prefixMap, LinkedList<TreeNode> treeNodes) {
//        if (root == null) {
//            return 0;
//        }
//        Integer prefixSum = prefixMap.get(root) - targetSum;
//        int res = 0;
//        if (prefixSum == 0) {
//            res = res + 1;
//        }
//        if (root.val - targetSum == 0) {
//            res = res + 1;
//        }
//        for (TreeNode treeNode : treeNodes) {
//            if (Objects.equals(prefixMap.get(treeNode), prefixSum)) {
//                res = res + 1;
//                break;
//            }
//        }
//        treeNodes.add(root);
//        res = res + pathSum(root.left, targetSum, prefixMap, treeNodes);
//        res = res + pathSum(root.right, targetSum, prefixMap, treeNodes);
//        treeNodes.removeLast();
//        return res;
//    }
//
//    private void buildMap(Map<TreeNode, Integer> prefixMap, TreeNode root, int sum) {
//        if (root == null) {
//            return;
//        }
//        sum = root.val + sum;
//        prefixMap.put(root, sum);
//        buildMap(prefixMap, root.left, sum);
//        buildMap(prefixMap, root.right, sum);
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}