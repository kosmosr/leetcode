package top.mollysu.leetcode.solutions.removeNthNodeFromEndOfList019;

import top.mollysu.leetcode.ListNode;
import top.mollysu.leetcode.utils.LinkedListUtil;

/**
 * @author zmh
 * @date 2019-04-09 20:15
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * example:
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * <p>
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 * <p>
 * 进阶：
 * <p>
 * 你能尝试使用一趟扫描实现吗？
 */
public class Solution {

    private int sum;

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = LinkedListUtil.constructor(1, 2);
        ListNode result = solution.removeNthFromEndRecursion(head, 2);
        System.out.println(result);
    }

    /**
     * 使用双指针，使用快指针先走n步，然后快慢指针同时移动，当快指针没有下一步时，修改慢指针next -> next.next
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dommyNode = new ListNode(0);
        dommyNode.next = head;
        ListNode slow = dommyNode;
        ListNode fast = dommyNode;

        for (int i = 0; i < n && fast.next != null; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dommyNode.next;
    }

    // 递归法
    public ListNode removeNthFromEndRecursion(ListNode head, int n) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = recursion(head, n);
        return dummyNode.next;
    }

    public ListNode recursion(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        head.next = recursion(head.next, n);
        sum++;
        return n == sum ? head.next : head;
    }

}
