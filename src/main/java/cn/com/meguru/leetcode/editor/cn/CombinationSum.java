//组合总和

//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的数字可以无限制重复被选取。 
//
// 说明： 
//
// 
// 所有数字（包括 target）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1： 
//
// 输入：candidates = [2,3,6,7], target = 7,
//所求解集为：
//[
//  [7],
//  [2,2,3]
//]
// 
//
// 示例 2： 
//
// 输入：candidates = [2,3,5], target = 8,
//所求解集为：
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//] 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// candidate 中的每个元素都是独一无二的。 
// 1 <= target <= 500 
// 
// Related Topics 数组 回溯算法 
// 👍 1219 👎 0


package cn.com.meguru.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        CombinationSum mainClass = new CombinationSum();
        Solution solution = mainClass.new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            combinationSum(candidates, target, 0, 0, new ArrayList<Integer>());
            return res;
        }

        private void combinationSum(int[] candidates, int target, int index, int sum, List<Integer> path) {
            for (int i = index; i < candidates.length; i++) {
                int val = candidates[i];
                if (sum + val < target) {
                    path.add(val);
                    combinationSum(candidates, target, i, sum + val, path);
                    path.remove(path.size() - 1);
                } else if (sum + val == target) {
                    path.add(val);
                    res.add(new ArrayList<>(path));
                    path.remove(path.size() - 1);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}