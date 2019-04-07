package main.java.mergeTwoSortedLinkedLists021;

import main.java.ListNode;
import main.java.utils.LinkedListUtil;

/**
 * @author zmh
 * @date 2019-04-05 22:58
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class Solution {

    public static void main(String[] args) {
        ListNode l1 = LinkedListUtil.constructor(1, 2, 4);
        ListNode l2 = LinkedListUtil.constructor(1, 3, 4);
        Solution solution = new Solution();
        ListNode res = solution.mergeTwoLists(l1, l2);
        System.out.println(res);
    }

    /**
     * 参考归并排序的归并操作
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode dummyNode = new ListNode(0);
        ListNode curr = dummyNode;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
                curr = curr.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
                curr = curr.next;
            }
        }
        if (l1 == null) {
            curr.next = l2;
        } else if (l2 == null) {
            curr.next = l1;
        }
        return dummyNode.next;
    }

    /**
     * 参考leetcode上的解题
     * https://leetcode.com/problems/merge-two-sorted-lists/discuss/9715/Java-1-ms-4-lines-codes-using-recursion
     */
    public ListNode mergeTwoListsClear(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
