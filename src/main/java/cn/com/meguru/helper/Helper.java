package cn.com.meguru.helper;

import java.util.*;
import java.util.function.Consumer;

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


    class Graph {
        Map<Integer, GraphVector> vectors = new HashMap<>();
        void addVector(Integer i) {
            GraphVector graphVector = vectors.get(i);
            if (graphVector != null) {
                return;
            }
            vectors.put(i, new GraphVector(i));
        }

        void addNode(int vector, int val) {
            GraphNode graphNode = new GraphNode(val);
            GraphVector graphVector = vectors.get(vector);
            graphNode.next = graphVector.node;
            graphVector.node = graphNode;
            GraphVector outVector = vectors.get(val);
            outVector.indegree = outVector.indegree + 1;
        }
    }

    class GraphVector {
        int val;
        int indegree = 0;
        GraphNode node;

        public GraphVector(int val) {
            this.val = val;
        }
    }

    class GraphNode {
        int val;
        GraphNode next;

        public GraphNode(int val) {
            this.val = val;
        }
    }


    /**
     * 中序遍历二叉树
     * @param root
     * @param consumer
     */
    public static void midRootForeach(TreeNode root, Consumer<TreeNode> consumer) {
        if (root == null) {
            return;
        }
        midRootForeach(root.left, consumer);
        consumer.accept(root);
        midRootForeach(root.right, consumer);
    }

    /**
     * 按右-中-左遍历二叉树
     * @param root
     * @param consumer
     */
    public static void rightMidLeftForeach(TreeNode root, Consumer<TreeNode> consumer) {
        if (root == null) {
            return;
        }
        rightMidLeftForeach(root.right, consumer);
        consumer.accept(root);
        rightMidLeftForeach(root.left, consumer);
    }

    public static void morrisRightMidLeftForeach(TreeNode root, Consumer<TreeNode> consumer) {
        while (root != null) {
            TreeNode pre = root.right;
            if (pre == null) {
                consumer.accept(root);
                root = root.left;
                continue;
            }
            while (pre.left != null && pre.left != root) {
                pre = pre.left;
            }
            if (pre.left == null) {
                pre.left = root;
                root = root.right;
            } else {
                consumer.accept(root);
                pre.left = null;
                root = root.left;
            }
        }
    }
}
