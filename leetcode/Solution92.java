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
        ListNode start = new ListNode(head.val);
        ListNode end = start;

        while (count > 0) {
            head = head.next;
            ListNode temp = new ListNode(head.val);
            temp.next = start;
            start = temp;
            count--;
        }

        end.next = head.next;
        return start;
    }
}