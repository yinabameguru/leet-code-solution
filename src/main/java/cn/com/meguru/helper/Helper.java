package cn.com.meguru.helper;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Helper {
    public void swapChar(char[] chars, int i, int j) {
        char c = chars[i];
        chars[i] = chars[j];
        chars[j] = c;
    }

    public void swapInt(int[] nums, int i, int j) {
        int c = nums[i];
        nums[i] = nums[j];
        nums[j] = c;
    }

    /**
     * 基于nums[workStart]进行partition
     */
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

    public static int[][] toArray(String s) {
        s = s.substring(2, s.length() - 2);
        String[] arrays = s.split("],\\[");

        int[][] ints = Arrays.stream(arrays)
                .map(array -> {
                    String[] stringArray = array.split(",");
                    int[] arr = Arrays.stream(stringArray)
                            .map(Integer::valueOf)
                            .mapToInt(Integer::intValue)
                            .toArray();
                    return arr;
                }).toArray(int[][]::new);
        return ints;
    }

    public static int[] toArray2(String s) {
        s = s.substring(1, s.length() - 1);
        String[] stringArray = s.split(",");
        int[] arr = Arrays.stream(stringArray)
                .map(Integer::valueOf)
                .mapToInt(Integer::intValue)
                .toArray();
        return arr;
    }

    public static ListNode toLinkedList(String s) {
        int[] ints = toArray2(s);
        ListNode head = new ListNode(ints[0]);
        ListNode pre = head;
        for (int i = 1; i < ints.length; i++) {
            pre.next = new ListNode(ints[i]);
            pre = pre.next;
        }
        return head;
    }

    public static TreeNode arrayToTree(Integer[] arr) {
        Deque<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(arr[0]);
        queue.push(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (i < arr.length) {
                if (arr[i] != null) {
                    TreeNode left = new TreeNode(arr[i]);
                    node.left = left;
                    queue.offer(left);
                }
                i = i + 1;
            }
            if (i< arr.length) {
                if (arr[i] != null) {
                    TreeNode right = new TreeNode(arr[i]);
                    node.right = right;
                    queue.offer(right);
                }
                i = i + 1;
            }
        }
        return root;
    }

    class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
