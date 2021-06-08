//数组中的第K个最大元素

//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 示例 1: 
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 说明: 
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。 
// Related Topics 堆 分治算法 
// 👍 1123 👎 0


package cn.com.meguru.leetcode.editor.cn;

import cn.com.meguru.helper.Helper;

public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        KthLargestElementInAnArray mainClass = new KthLargestElementInAnArray();
        Solution solution = mainClass.new Solution();
        solution.findKthLargest(Helper.toArray2("[3,2,1,5,6,4]"), 1);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;
        int[] heap = new int[heapSize];
        for (int i = 0; i < heapSize; i++) {
            heap[i] = nums[i];
        }
        initHeap(heap, heapSize);
        int res = 0;
        for (int i = 0; i < k; i++) {
            res = removeHeapRoot(heap, heapSize);
            heapSize = heapSize - 1;
        }
        return res;
    }

    private int removeHeapRoot(int[] heap, int heapSize) {
        int res = heap[0];
        swapInt(heap, 0, heapSize - 1);
        heapify(heap, 0, heapSize - 1);
        return res;
    }

    private void initHeap(int[] heap, int heapSize) {
        int root = (heap.length - 1) / 2;
        for (int i = root; i >= 0; i--) {
            heapify(heap, i, heapSize);
        }
    }

    private void heapify(int[] heap, int root, int heapSize) {
        int left = 2 * root + 1, right = 2 * root + 2;
        if (left < heapSize && heap[left] > heap[root]) {
            swapInt(heap, left, root);
            heapify(heap, left, heapSize);
        }
        if (right < heapSize && heap[right] > heap[root]) {
            swapInt(heap, right, root);
            heapify(heap, right, heapSize);
        }
    }


    public void swapInt(int[] nums, int i, int j) {
        int c = nums[i];
        nums[i] = nums[j];
        nums[j] = c;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}