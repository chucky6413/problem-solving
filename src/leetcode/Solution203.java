package leetcode;

public class Solution203 {
    public ListNode removeElements(ListNode node, int val) {
        ListNode head = new ListNode(0);
        head.next = node;
        node = head;

        while (node.next != null) {
            if (node.next.val == val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }

        return head.next;
    }
}