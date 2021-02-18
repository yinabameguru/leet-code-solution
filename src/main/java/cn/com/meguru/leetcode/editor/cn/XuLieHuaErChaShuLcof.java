//序列化二叉树

//请实现两个函数，分别用来序列化和反序列化二叉树。 
//
// 示例: 
//
// 你可以将以下二叉树：
//
//    1
//   / \
//  2   3
//     / \
//    4   5
//
//序列化为 "[1,2,3,null,null,4,5]" 
//
// 注意：本题与主站 297 题相同：https://leetcode-cn.com/problems/serialize-and-deserialize-b
//inary-tree/ 
// Related Topics 树 设计 
// 👍 109 👎 0


package cn.com.meguru.leetcode.editor.cn;

import cn.com.meguru.helper.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class XuLieHuaErChaShuLcof {
    public static void main(String[] args) {
        XuLieHuaErChaShuLcof mainClass = new XuLieHuaErChaShuLcof();
        Codec codec = mainClass.new Codec();
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
public class Codec {

    private StringBuilder treeSb = new StringBuilder();

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        serializeSb(root);
        return treeSb.substring(0, treeSb.length() - 1);
    }

    private void serializeSb(TreeNode root) {
        if (root == null) {
            treeSb.append("null,");
            return;
        }
        treeSb.append(root.val)
                .append(",");
        serializeSb(root.left);
        serializeSb(root.right);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> nodes = Arrays.stream(data.split(","))
                .collect(Collectors.toList());

        return deserialize(nodes);
    }

    private TreeNode deserialize(List<String> nodes) {
        String valString = nodes.remove(0);
        if (valString.equals("null")) {
            return null;
        }
        int val = Integer.parseInt(valString);
        TreeNode node = new TreeNode(val);

        node.left = deserialize(nodes);
        node.right = deserialize(nodes);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

}