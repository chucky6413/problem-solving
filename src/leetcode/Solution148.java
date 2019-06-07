package leetcode;

public class Solution148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prevCenter = findPrevCenter(head);
        ListNode center = prevCenter.next;
        prevCenter.next = null;
        head = merge(sortList(head), sortList(center));
        return head;
    }

    private ListNode findPrevCenter(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode merge(ListNode first, ListNode center) {
        ListNode head = new ListNode(0);
        ListNode tail = head;

        while (first != null || center != null) {
            if (first.val < center.val) {
                tail.next = first;
                first = first.next;
            } else {
                tail.next = center;
                center = center.next;
            }

            tail = tail.next;

            if (first == null) {
                tail.next = center;
                break;
            }

            if (center == null) {
                tail.next = first;
                break;
            }
        }

        return head.next;
    }
}