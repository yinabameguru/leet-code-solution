//前 K 个高频元素

//给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 
//输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// k 的取值范围是 [1, 数组中不相同的元素的个数] 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的 
// 
//
// 
//
// 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。 
// Related Topics 数组 哈希表 分治 桶排序 计数 快速选择 排序 堆（优先队列） 
// 👍 826 👎 0


package cn.com.meguru.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {
    public static void main(String[] args) {
        TopKFrequentElements mainClass = new TopKFrequentElements();
        Solution solution = mainClass.new Solution();
        solution.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer count = map.getOrDefault(num, 0);
            count = count + 1;
            map.put(num, count);
        }
        List<Integer>[] arr = new List[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            List<Integer> list = arr[entry.getValue()];
            if (list == null) {
                list = new ArrayList<>();
                list.add(entry.getKey());
                arr[entry.getValue()] = list;
            } else {
                list.add(entry.getKey());
            }
        }
        int[] res = new int[k];
        int count = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            List<Integer> list = arr[i];
            if (list != null) {
                for (Integer integer : list) {
                    res[count] = integer;
                    count = count + 1;
                    if (count == k) {
                        break;
                    }
                }
            }
            if (count == k) {
                break;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}