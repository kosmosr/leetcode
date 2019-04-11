package top.mollysu.leetcode.solutions.intersectionOfTwoLinkedLists160;

import top.mollysu.leetcode.ListNode;
import top.mollysu.leetcode.utils.LinkedListUtil;

/**
 * @author zmh
 * @date 2019-04-11 11:41
 * 编写一个程序，找到两个单链表相交的起始节点。
 * {@link <a>https://leetcode-cn.com/problems/intersection-of-two-linked-lists/</a>}
 */
public class Solution {

    public static void main(String[] args) {
        ListNode tail = LinkedListUtil.constructor(8, 4, 5);
        ListNode headA = LinkedListUtil.constructor(4, 1);
        ListNode headB = LinkedListUtil.constructor(5, 0, 1);
        headA.next.next = tail;
        headB.next.next.next = tail;
        Solution solution = new Solution();
        ListNode intersectionNode = solution.getIntersectionNode(headA, headB);
        System.out.println(intersectionNode);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
}
