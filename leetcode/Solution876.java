public class Solution876 {
    public ListNode middleNode(ListNode head) {
        ListNode walker = head;
        ListNode jumper = head;

        while (jumper != null && jumper.next != null) {
            walker = walker.next;
            jumper = jumper.next.next;
        }

        return walker;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}