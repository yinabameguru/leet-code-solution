//最长连续序列

//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。 
//
// 
//
// 进阶：你可以设计并实现时间复杂度为 O(n) 的解决方案吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 
//
// 示例 2： 
//
// 
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 104 
// -109 <= nums[i] <= 109 
// 
// Related Topics 并查集 数组 
// 👍 774 👎 0


package cn.com.meguru.leetcode.editor.cn;

import cn.com.meguru.helper.Helper;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        LongestConsecutiveSequence mainClass = new LongestConsecutiveSequence();
        Solution solution = mainClass.new Solution();
        solution.longestConsecutive(Helper.toArray2("[100,4,200,1,3,2]"));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private Map<Integer, Integer> valParentMap = new HashMap<>();

    public int longestConsecutive(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            valParentMap.put(nums[i], nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            union(nums[i], nums[i] + 1);
        }
        for (int i = 0; i < nums.length; i++) {
            Integer root = getRoot(nums[i]);
            result = Math.max(nums[i] - root + 1, result);
        }
        return result;
    }

    private void union(int i, int j) {
        Integer root = getRoot(i);
        Integer root2 = getRoot(j);
        if (root == null || root2 == null) {
            return;
        }
        if (root < root2) {
            valParentMap.put(root2, root);
        } else if (root > root2) {
            valParentMap.put(root, root2);
        }
    }

    private Integer getRoot(int num) {
        Integer parent = valParentMap.get(num);
        if (parent == null || parent == num) {
            return parent;
        }
        Integer root = getRoot(parent);
        valParentMap.put(num, root);
        return root;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}