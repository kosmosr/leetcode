package main.java.removeLinkedListElements203;

import main.java.ListNode;

/**
 * @author zmh
 * @date 2019-04-06 21:15
 * 删除链表中等于给定值 val 的所有节点。
 * <p>
 * example:
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class Solution {
    /**
     * code clean
     * 递归求解 7ms
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;

        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    /**
     * 非递归求解 2ms
     */
    public ListNode removeElements2(ListNode head, int val) {
        if (head == null) return null;
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode curr = dummyNode;
        while (curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return dummyNode.next;
    }
}
