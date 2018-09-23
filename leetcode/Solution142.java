public class Solution142 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;

        ListNode turtle = head;
        ListNode rabbit = head;

        while (rabbit.next != null && rabbit.next.next != null) {
            turtle = turtle.next;
            rabbit = rabbit.next.next;

            if (turtle == rabbit) {
                ListNode turtleFriend = head;

                while (turtleFriend != turtle) {
                    turtleFriend = turtleFriend.next;
                    turtle = turtle.next;
                }

                return turtle;
            }
        }

        return null;
    }
}