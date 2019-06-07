package leetcode;

public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;

        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }

        if (length == n) {
            return head.next;
        }

        n = length - n;
        node = head;
        while (--n > 0) {
            node = node.next;
        }
        node.next = node.next.next;
        return head;
    }
}