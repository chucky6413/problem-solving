public class Solution92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode prevOfStartNode = head;
        if (m == 1) {
            return reverse(prevOfStartNode, n - m);
        }

        // find start point
        for (int i = 2; i < m; i++) {
            prevOfStartNode = prevOfStartNode.next;
        }
        prevOfStartNode.next = reverse(prevOfStartNode.next, n - m);

        return head;
    }

    private ListNode reverse(ListNode head, int count) {
        ListNode newHead = new ListNode(head.val);
        ListNode newTail = newHead;

        while (count > 0) {
            head = head.next;
            ListNode temp = new ListNode(head.val);
            temp.next = newHead;
            newHead = temp;
            count--;
        }

        newTail.next = head.next;
        return newHead;
    }
}