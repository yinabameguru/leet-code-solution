//数据流中的中位数

//如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数
//值排序之后中间两个数的平均值。 
//
// 例如， 
//
// [2,3,4] 的中位数是 3 
//
// [2,3] 的中位数是 (2 + 3) / 2 = 2.5 
//
// 设计一个支持以下两种操作的数据结构： 
//
// 
// void addNum(int num) - 从数据流中添加一个整数到数据结构中。 
// double findMedian() - 返回目前所有元素的中位数。 
// 
//
// 示例 1： 
//
// 输入：
//["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
//[[],[1],[2],[],[3],[]]
//输出：[null,null,null,1.50000,null,2.00000]
// 
//
// 示例 2： 
//
// 输入：
//["MedianFinder","addNum","findMedian","addNum","findMedian"]
//[[],[2],[],[3],[]]
//输出：[null,null,2.00000,null,2.50000] 
//
// 
//
// 限制： 
//
// 
// 最多会对 addNum、findMedian 进行 50000 次调用。 
// 
//
// 注意：本题与主站 295 题相同：https://leetcode-cn.com/problems/find-median-from-data-strea
//m/ 
// Related Topics 堆 设计 
// 👍 102 👎 0


package cn.com.meguru.leetcode.editor.cn;

import java.util.PriorityQueue;

public class ShuJuLiuZhongDeZhongWeiShuLcof {
    public static void main(String[] args) {
        ShuJuLiuZhongDeZhongWeiShuLcof mainClass = new ShuJuLiuZhongDeZhongWeiShuLcof();
        MedianFinder medianFinder = mainClass.new MedianFinder();
    }

//leetcode submit region begin(Prohibit modification and deletion)
    class MedianFinder {

    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(25001, (o1, o2) -> o2 - o1);

    private PriorityQueue<Integer> minHeap = new PriorityQueue<>(25001);

    private int size = 0;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {

        }

        public void addNum(int num) {
            size = size + 1;
            if ((size & 1) == 1) {
                Integer minHeapHead = minHeap.peek();
                if (minHeapHead == null || minHeapHead > num) {
                    maxHeap.offer(num);
                } else {
                    minHeap.offer(num);
                    maxHeap.offer(minHeap.poll());
                }
            } else {
                Integer maxHeapHead = maxHeap.peek();
                if (maxHeapHead == null || maxHeapHead < num) {
                    minHeap.offer(num);
                } else {
                    maxHeap.offer(num);
                    minHeap.offer(maxHeap.poll());
                }
            }
        }

        public double findMedian() {
            if ((size & 1) == 1) {
                return maxHeap.peek().doubleValue();
            }
            return (maxHeap.peek() + minHeap.peek()) / 2d;
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
//leetcode submit region end(Prohibit modification and deletion)

}