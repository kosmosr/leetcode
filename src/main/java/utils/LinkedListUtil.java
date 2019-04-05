package main.java.utils;

import main.java.ListNode;

/**
 * @author zmh
 * @date 2019-04-05 23:00
 */
public class LinkedListUtil {
    public static ListNode constructor(int... numbers) {
        ListNode dummyNode = new ListNode();
        ListNode curr = dummyNode;
        for (int number : numbers) {
            curr.next = new ListNode(number);
            curr = curr.next;
        }
        return dummyNode.next;
    }
}
