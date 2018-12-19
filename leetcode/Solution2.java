public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode tail = head;

        int sum, v, c = 0;
        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + c;
            v = sum % 10;
            c = sum / 10;

            tail.next = new ListNode(v);
            tail = tail.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            sum = l1.val + c;
            v = sum % 10;
            c = sum / 10;

            tail.next = new ListNode(v);
            tail = tail.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            sum = l2.val + c;
            v = sum % 10;
            c = sum / 10;

            tail.next = new ListNode(v);
            tail = tail.next;
            l2 = l2.next;
        }

        if (c == 1) {
            tail.next = new ListNode(1);
        }

        return head.next;
    }
}