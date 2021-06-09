//回文链表

//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针 
// 👍 1006 👎 0


package cn.com.meguru.leetcode.editor.cn;

import cn.com.meguru.helper.Helper;
import cn.com.meguru.helper.ListNode;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        PalindromeLinkedList mainClass = new PalindromeLinkedList();
        Solution solution = mainClass.new Solution();
        solution.isPalindrome(Helper.toLinkedList("[1,2,1]"));
    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return true;
        }
        ListNode slow = head, quick = head;
        while (quick != null) {
            slow = slow.next;
            quick = quick.next;
            if (quick != null) {
                quick = quick.next;
            }
        }
        ListNode head2 = reverse(slow);
        do {
            if (head.val == head2.val) {
                head = head.next;
                head2 = head2.next;
            } else {
                return false;
            }
        } while (head != null && head2 != null);
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode next = head.next, pre = null, cur = head;

        while (next != null) {
            cur.next = pre;

            pre = cur;
            cur = next;
            next = next.next;
        }
        cur.next = pre;
        return cur;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}