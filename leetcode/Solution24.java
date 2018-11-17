/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class Solution24 {
    public ListNode swapPairs(ListNode node) {
        ListNode head = new ListNode(0);
        head.next = node;

        ListNode prev = head;
        while (node != null && node.next != null) {
            prev.next = node.next;

            // swap two adjacent nodes
            node.next = node.next.next;
            prev.next.next = node;

            // jumping two node
            prev = prev.next.next;
            node = prev.next;
        }

        return head.next;
    }
}