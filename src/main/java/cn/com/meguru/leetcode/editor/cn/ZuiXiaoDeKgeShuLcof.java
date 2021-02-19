//最小的k个数

//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
// Related Topics 堆 分治算法 
// 👍 192 👎 0


package cn.com.meguru.leetcode.editor.cn;

import java.util.PriorityQueue;

public class ZuiXiaoDeKgeShuLcof {
    public static void main(String[] args) {
        ZuiXiaoDeKgeShuLcof mainClass = new ZuiXiaoDeKgeShuLcof();
        Solution solution = mainClass.new Solution();
        int[] leastNumbers = solution.getLeastNumbers(new int[]{0,0,1,2,4,2,2,3,1,4}, 8);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 知道数据范围，计数排序法 O(n)
         */
        public int[] getLeastNumbers(int[] arr, int k) {
            if (k == 0 || arr.length == 0) {
                return new int[0];
            }
            // 统计每个数字出现的次数
            int[] counter = new int[10001];
            for (int num: arr) {
                counter[num]++;
            }
            // 根据counter数组从头找出k个数作为返回结果
            int[] res = new int[k];
            int idx = 0;
            for (int num = 0; num < counter.length; num++) {
                while (counter[num]-- > 0 && idx < k) {
                    res[idx++] = num;
                }
                if (idx == k) {
                    break;
                }
            }
            return res;
        }


        /**
         * 大根堆
         */
        public int[] getLeastNumbers2(int[] arr, int k) {
            if (k == 0) {
                return new int[0];
            }
            PriorityQueue<Integer> heap = new PriorityQueue<>(k, (o1, o2) -> o2 - o1);
            for (int i : arr) {
                if (heap.size() < k) {
                    heap.offer(i);
                    continue;
                }
                Integer head = heap.peek();
                if (i < head) {
                    heap.poll();
                    heap.offer(i);
                }
            }
            return heap.stream().mapToInt(value -> value).toArray();
        }

        /**
         * 基于partition实现
         */
        public int[] getLeastNumbers1(int[] arr, int k) {
            if (k == 0) {
                return new int[0];
            }

            int[] res = new int[k];

            getLeastNumbers(arr, k, 0, arr.length - 1);
            for (int i = 0; i < k; i++) {
                res[i] = arr[i];
            }
            return res;
        }

        private  void getLeastNumbers(int[] arr, int k, int workStart, int workEnd) {
            int index = partition(arr, workStart, workEnd);

            if (index == k - 1) {
                return;
            }

            if (index > k - 1) {
                getLeastNumbers(arr, k, workStart, index - 1);
            }

            if (index < k - 1) {
                getLeastNumbers(arr, k, index + 1, workEnd);
            }
        }

        private int partition(int[] nums, int workStart, int workEnd) {
            if (workStart == workEnd) {
                return workStart;
            }
            int next = workStart + 1;
            if (nums[workStart] <= nums[next]) {
                swapInt(nums, next, workEnd);
                workEnd = workEnd - 1;
            } else {
                swapInt(nums, workStart, next);
                workStart = workStart + 1;
            }
            return partition(nums, workStart, workEnd);
        }

        public void swapInt(int[] nums, int i, int j) {
            int c = nums[i];
            nums[i] = nums[j];
            nums[j] = c;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}