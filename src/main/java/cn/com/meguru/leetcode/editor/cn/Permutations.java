//全排列

//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
// Related Topics 回溯算法 
// 👍 1347 👎 0


package cn.com.meguru.leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

public class Permutations {
    public static void main(String[] args) {
        Permutations mainClass = new Permutations();
        Solution solution = mainClass.new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        Set<Integer> visitedSet = new HashSet<>();
        Set<Integer> unVisitSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        for (int i = 0; i < nums.length; i++) {
            permute(nums, i, res, item, visitedSet, unVisitSet);
        }
        return res;
    }


    public void permute(int[] nums, int i, List<List<Integer>> res, List<Integer> item, Set<Integer> visitedSet, Set<Integer> unVisitSet) {
        if (visitedSet.contains(nums[i])) {
            return;
        }
        item.add(nums[i]);
        if (item.size() == nums.length) {
            res.add(new ArrayList<>(item));
            item.remove(item.size() - 1);
            return;
        }
        visitedSet.add(nums[i]);
        unVisitSet.remove(nums[i]);
        for (int j = 0; j < nums.length; j++) {
            permute(nums, j, res, item, visitedSet, unVisitSet);
        }
        visitedSet.remove(nums[i]);
        unVisitSet.add(nums[i]);
        item.remove(item.size() - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}