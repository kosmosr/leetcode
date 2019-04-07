package main.java.rotateLinkedList061;

import main.java.ListNode;
import main.java.utils.LinkedListUtil;

/**
 * @author zmh
 * @date 2019-04-06 14:34
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * example:
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * <p>
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode res = solution.rotateRight2(LinkedListUtil.constructor(1, 2, 3, 4, 5), 2);
        System.out.println(res);
    }

    /**
     * 参考LeetCode上的讨论
     * https://leetcode.com/problems/rotate-list/discuss/22715/Share-my-java-solution-with-explanation
     * 时间复杂度 O(n)
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;

        // Get the length
        int i;
        for (i = 0; fast.next != null; i++) {
            fast = fast.next;
        }

        // Move to the (i - k % i) node
        for (int j = i - k % i; j > 0; j--) {
            slow = slow.next;
        }

        // rotation
        fast.next = dummy.next;
        dummy.next = slow.next;
        slow.next = null;
        return dummy.next;
    }

    /**
     * 循环k次，把每次的尾结点提到首节点
     * 时间复杂度：O(n¹)，右上角是k不是1，符号不知道怎么打。。
     */
    public ListNode rotateRight2(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        // Get the length and valid k
        int length = 0;
        for (ListNode x = head; x != null; x = x.next) {
            length++;
        }
        k %= length;
        ListNode curr = head;
        for (int i = 0; i < k; i++) {
            while (true) {
                if (curr.next.next == null) {
                    ListNode oldHead = head;
                    head = new ListNode(curr.next.val);
                    head.next = oldHead;
                    curr.next = null;
                    curr = head;
                    break;
                } else {
                    curr = curr.next;
                }
            }
        }
        return head;
    }
}
