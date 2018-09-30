public class Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode rs = new ListNode(0);

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                rs.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                rs.next = new ListNode(l2.val);
                l2 = l2.next;
            }
        }

        while (l1 != null) {
            rs.next = new ListNode(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            rs.next = new ListNode(l2.val);
            l2 = l2.next;
        }

        return rs.next;
    }
}