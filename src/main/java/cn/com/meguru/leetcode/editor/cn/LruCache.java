//LRU 缓存机制

//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。 
//
// 
// 
// 实现 LRUCache 类： 
//
// 
// LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上
//限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。 
// 
//
// 
// 
// 
//
// 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 3000 
// 0 <= value <= 104 
// 最多调用 3 * 104 次 get 和 put 
// 
// Related Topics 设计 
// 👍 1408 👎 0


package cn.com.meguru.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class LruCache {
    public static void main(String[] args) {
        LruCache mainClass = new LruCache();
        LRUCache lruCache = mainClass.new LRUCache(2);
        lruCache.get(2);
        lruCache.put(2, 6);
        lruCache.get(1);
        lruCache.put(1, 5);
        lruCache.put(1, 2);
        lruCache.get(1);
        lruCache.get(2);
//        lruCache.get(2);
//        lruCache.put(1, 1);
//        lruCache.put(2, 2);
//        lruCache.get(1);
//        lruCache.put(3, 3);
//        lruCache.get(2);
//        lruCache.put(4, 4);
//        lruCache.get(1);
//        lruCache.get(3);
//        lruCache.get(4);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {

    Node head = new Node(), end = new Node();

    Map<Integer, Node> map = new HashMap<>();

    int capacity;

    int count = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = end;
        end.pre = head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node != null) {
            moveToHead(node);
            return node.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.val = value;
            moveToHead(node);
        } else {
            Node nodeNew = new Node(key, value);
            addToHead(nodeNew);
            if (count > capacity) {
                remove(end.pre);
            }
        }
    }

    private void moveToHead(Node node) {
        remove(node);
        addToHead(node);
    }

    private void remove(Node node) {
        Node pre = node.pre;
        Node next = node.next;
        pre.next = next;
        next.pre = pre;
        map.remove(node.key);
        count = count - 1;
    }

    private void addToHead(Node nodeNew) {
        Node next = head.next;
        head.next = nodeNew;
        nodeNew.pre = head;
        nodeNew.next = next;
        next.pre = nodeNew;
        map.put(nodeNew.key, nodeNew);
        count = count + 1;
    }

    class Node {
        int key;
        int val;
        Node pre;
        Node next;

        public Node() {
        }

        public Node(int key, int val) {
            this.val = val;
            this.key = key;
        }

        public Node(int key, int val, Node pre, Node next) {
            this.val = val;
            this.key = key;
            this.pre = pre;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", val=" + val +
                    '}';
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}