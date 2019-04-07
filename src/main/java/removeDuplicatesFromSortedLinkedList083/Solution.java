package main.java.removeDuplicatesFromSortedLinkedList083;

import main.java.ListNode;

/**
 * @author zmh
 * @date 2019-04-06 17:52
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = deleteDuplicates(head.next);
        if (next.val == head.val) {
            head = next;
        } else {
            head.next = next;
        }
        return head;
    }
}
