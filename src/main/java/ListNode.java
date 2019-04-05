package main.java;

/**
 * @author zmh
 * @date 2019-04-05 22:59
 */
public class ListNode {
    public int val;

    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

/*    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        ListNode cur = this;
        while (cur != null) {
            if (cur.next != null) {
                builder.append(cur.val).append(",");
                cur = cur.next;
            } else {
                builder.append(cur.val);
                cur = cur.next;
            }
        }
        return "ListNode " + builder.toString();
    }*/
}
