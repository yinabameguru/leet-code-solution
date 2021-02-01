//二叉树中和为某一值的路径

//输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。 
//
// 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
// 
//
// 返回: 
//
// [
//   [5,4,11,2],
//   [5,8,4,5]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 10000 
// 
//
// 注意：本题与主站 113 题相同：https://leetcode-cn.com/problems/path-sum-ii/ 
// Related Topics 树 深度优先搜索 
// 👍 122 👎 0


package cn.com.meguru.leetcode.editor.cn;

import cn.com.meguru.helper.TreeNode;

import java.util.ArrayList;
import java.util.List;

import static cn.com.meguru.helper.TreeNode.stringToTreeNode;

public class ErChaShuZhongHeWeiMouYiZhiDeLuJingLcof {
    public static void main(String[] args) {
        ErChaShuZhongHeWeiMouYiZhiDeLuJingLcof mainClass = new ErChaShuZhongHeWeiMouYiZhiDeLuJingLcof();
        Solution solution = mainClass.new Solution();
        TreeNode treeNode = stringToTreeNode("[1,-2,-3,1,3,-2,null,-1]");
        List<List<Integer>> lists = solution.pathSum(treeNode, -1);
        System.out.println(lists);

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

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(new ArrayList<Integer>(), root, sum, 0);
        return result;
    }

    private void dfs(List<Integer> path, TreeNode root, int sum, int curSum) {
        if (root == null) {
            return;
        }
        curSum = curSum + root.val;
        path.add(root.val);
        if (sum == curSum && root.left == null && root.right == null) {
            result.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }
        if (root.left != null) {
            dfs(path, root.left, sum, curSum);
        }
        if (root.right != null) {
            dfs(path, root.right, sum, curSum);
        }
        path.remove(path.size() - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}