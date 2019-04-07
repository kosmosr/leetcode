package main.java.addTwoNumbers002;

import main.java.ListNode;

/**
 * @author zmh
 * @date 2019-04-07 19:36
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class Solution {

    /**
     * 通过一个int变量保存结点之和，每次/= 10解决进位+1，并取模10保存节点值
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0);
        ListNode curr = dummyNode;

        int temp = 0;
        while (l1 != null || l2 != null) {
            temp /= 10;
            if (l1 != null) {
                temp += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                temp += l2.val;
                l2 = l2.next;
            }
            curr.next = new ListNode(temp % 10);
            curr = curr.next;
        }
        if (temp > 9) {
            curr.next = new ListNode(1);
        }
        return dummyNode.next;
    }
}
