public class Solution141 {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode turtle = head;
        ListNode rabbit = head;

        while (rabbit.next != null && rabbit.next.next != null) {
            turtle = turtle.next;
            rabbit = rabbit.next.next;

            if (turtle == rabbit) {
                return true;
            }
        }

        return false;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}

