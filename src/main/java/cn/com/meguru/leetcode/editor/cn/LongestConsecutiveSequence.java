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

import java.util.*;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        LongestConsecutiveSequence mainClass = new LongestConsecutiveSequence();
        Solution solution = mainClass.new Solution();
        solution.longestConsecutive(Helper.toArray2("[100,4,200,1,3,2]"));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int longestConsecutive(int[] nums) {
//        return longestConsecutiveBySet(nums);
        return longestConsecutiveByDisjointSet(nums);
    }

    /**
     * 并查集
     */
    private int longestConsecutiveByDisjointSet(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        HashMap<Integer, Integer> numIdxMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numIdxMap.put(nums[i], i);
        }
        System.out.println("nums : " + Arrays.toString(nums));
        Dsu dsu = new Dsu(nums.length);
        System.out.println("inited : " + dsu.parent);
        for (int i = 0; i < nums.length; i++) {
            Integer preNumIdx = numIdxMap.get(nums[i] - 1);
            if (Objects.isNull(preNumIdx)) {
                continue;
            }
            dsu.unite(i, preNumIdx);
        }
        int res = 0;
        System.out.println("united : " + dsu.parent);
        for (int i = 0; i < nums.length; i++) {
            Integer rootIdx = dsu.find(i);
            res = Math.max(res, nums[rootIdx] - nums[i] + 1);
        }
        System.out.println("compress : " + dsu.parent);
        return res;
    }


    /**
     * 并查集
     */
    class Dsu {

        List<Integer> parent = null;

        /**
         * 初始化
         * @param size 容量
         */
        Dsu(int size) {
            parent = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                parent.add(i, i);
            }
        }

        /**
         * 查找item的根节点
         * @param item 查找结点
         * @return
         */
        public Integer find(Integer item) {
            Integer par = parent.get(item);
            if (Objects.equals(par, item)) {
                return item;
            }
            Integer root = find(par);
            // 路径压缩
            parent.set(item, root);
            return root;
        }

        /**
         * 合并
         * item2合并到item1下
         * @param item1 合并节点1，作为父节点
         * @param item2 合并节点2，作为子节点
         */
        public void unite(Integer item1, Integer item2) {
            parent.set(item2, item1);
        }




    }

    /**
     * set解法
     */
    private int longestConsecutiveBySet(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (set.contains(num - 1)) {
                continue;
            }
            int length = 1;
            while (set.contains(++num)) {
                length++;
            }
            res = Math.max(length, res);
        }
        return res;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}