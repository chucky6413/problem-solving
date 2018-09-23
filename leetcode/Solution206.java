public class Solution206 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        return recurSolve(head, null);
    }

    private ListNode recurSolve(ListNode cur, ListNode newHead) {
        if (cur == null) {
            return newHead;
        }

        ListNode next = cur.next;
        cur.next = newHead;
        return recurSolve(next, cur);
    }
}