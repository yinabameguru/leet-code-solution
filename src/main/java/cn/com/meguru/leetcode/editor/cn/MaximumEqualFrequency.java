//最大相等频率

//给你一个正整数数组 nums，请你帮忙从该数组中找出能满足下面要求的 最长 前缀，并返回该前缀的长度： 
//
// 
// 从前缀中 恰好删除一个 元素后，剩下每个数字的出现次数都相同。 
// 
//
// 如果删除这个元素后没有剩余元素存在，仍可认为每个数字都具有相同的出现次数（也就是 0 次）。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,2,1,1,5,3,3,5]
//输出：7
//解释：对于长度为 7 的子数组 [2,2,1,1,5,3,3]，如果我们从中删去 nums[4] = 5，就可以得到 [2,2,1,1,3,3]，里面每个数
//字都出现了两次。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,1,1,2,2,2,3,3,3,4,4,4,5]
//输出：13
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁵ 
// 
//
// Related Topics 数组 哈希表 👍 168 👎 0


package cn.com.meguru.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximumEqualFrequency {
    public static void main(String[] args) {
        MaximumEqualFrequency mainClass = new MaximumEqualFrequency();
        Solution solution = mainClass.new Solution();
        solution.maxEqualFreq(new int[]{10,2,8,9,3,8,1,5,2,3,7,6});
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxEqualFreq(int[] nums) {
        //记录每个数值出现的频次
        Map<Integer, Integer> valueFreqMap = new HashMap<>();
        //记录频次对应的数值数量
        Map<Integer, Integer> freqCountMap = new HashMap<>();
        //最大频次
        int maxFreq = 0;
        //最大前缀
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (valueFreqMap.containsKey(val)) {
                //记录valueFreqMap
                Integer originFreq = valueFreqMap.get(val);
                valueFreqMap.put(val, originFreq + 1);
                //调整freqCountMap
                //原freq减一，如果减为0remove
                Integer count = freqCountMap.get(originFreq);
                if (count == 1) {
                    freqCountMap.remove(originFreq);
                } else {
                    freqCountMap.put(originFreq, count - 1);
                }
                //新freq加一
                freqCountMap.compute(originFreq + 1, (k, v) -> v == null ? 1 : v + 1);
                //调整最大频次
                maxFreq = Math.max(maxFreq, originFreq + 1);
            } else {
                //记录valueFreqMap
                valueFreqMap.put(val, 1);
                //调整freqCountMap
                freqCountMap.compute(1, (k, v) -> v == null ? 1 : v + 1);
                //调整最大频次
                maxFreq = Math.max(maxFreq, 1);
            }
            //调整最大前缀
            //如果最大频次为1，符合前缀要求
            if (maxFreq == 1) {
                res = Math.max(res, i);
                continue;
            }
            //如果只有一个value，符合要求
            if (valueFreqMap.size() == 1) {
                res = Math.max(res, i);
                continue;
            }
            //如果仅有两种频次，且其中一个频次为1，且count为1，符合要求
            if (freqCountMap.size() == 2 && freqCountMap.containsKey(1) && freqCountMap.get(1) == 1) {
                res = Math.max(res, i);
                continue;
            }

            //如果仅有两种频次，且两种频次绝对值相差1，且绝对值大的频次count为1，符合要求
            if (freqCountMap.size() == 2) {
                List<Integer> list = new ArrayList<>(freqCountMap.keySet());
                int max = Math.max(list.get(0), list.get(1));
                int min = Math.min(list.get(0), list.get(1));
                if ((max - min == 1) && freqCountMap.get(max) == 1) {
                    res = Math.max(res, i);
                    continue;
                }
            }
        }
        return res + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}