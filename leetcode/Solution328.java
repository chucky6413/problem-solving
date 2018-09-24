public class Solution328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;

        ListNode oddTail = head;
        ListNode evenHead = head.next;
        ListNode evenTail = evenHead;

        while (evenTail != null && evenTail.next != null) {
            oddTail.next = evenTail.next;
            oddTail = oddTail.next;

            evenTail.next = evenTail.next.next;
            evenTail = evenTail.next;
        }

        oddTail.next = evenHead;

        return head;
    }
}