//二叉搜索树的后序遍历序列

//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。 
//
// 
//
// 参考以下这颗二叉搜索树： 
//
//      5
//    / \
//   2   6
//  / \
// 1   3 
//
// 示例 1： 
//
// 输入: [1,6,3,2,5]
//输出: false 
//
// 示例 2： 
//
// 输入: [1,3,2,6,5]
//输出: true 
//
// 
//
// 提示： 
//
// 
// 数组长度 <= 1000 
// 
// 👍 178 👎 0

package cn.com.meguru.leetcode.editor.cn;

public class ErChaSouSuoShuDeHouXuBianLiXuLieLcof {
    public static void main(String[] args) {
        ErChaSouSuoShuDeHouXuBianLiXuLieLcof erChaSouSuoShuDeHouXuBianLiXuLieLcof = new ErChaSouSuoShuDeHouXuBianLiXuLieLcof();
        Solution solution = erChaSouSuoShuDeHouXuBianLiXuLieLcof.new Solution();
        solution.verifyPostorder(new int[]{7, 4, 6, 5});
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean verifyPostorder(int[] postorder) {
            if (postorder.length == 0)
                return true;
            return verify(postorder, 0, postorder.length - 1);
        }

        private boolean verify(int[] postorder, int start, int end) {
            if (start == end)
                return true;
            int root = end, cur = start;
            while (cur < end) {
                if (postorder[cur] < postorder[root]) {
                    cur++;
                } else {
                    break;
                }
            }
            if (cur == end) {
                return verify(postorder, start, cur - 1);
            }

            for (int i = cur; i < end; i++) {
                if (postorder[i] < postorder[root]) {
                    return false;
                }
            }
            if (cur == start) {
                return verify(postorder, cur, end - 1);
            }
            return verify(postorder, start, cur - 1) && verify(postorder, cur, end - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
