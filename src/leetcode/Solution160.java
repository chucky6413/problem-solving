package leetcode;

/**
 * other amazing solution link
 * - https://leetcode.com/problems/intersection-of-two-linked-lists/discuss/49785/Java-solution-without-knowing-the-difference-in-len!
 */

public class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        ListNode tmpA = headA, tmpB = headB;

        while (tmpA != null || tmpB != null) {
            if (tmpA != null) {
                tmpA = tmpA.next;
                lenA++;
            }

            if (tmpB != null) {
                tmpB = tmpB.next;
                lenB++;
            }
        }

        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }

        while (lenA < lenB) {
            headB = headB.next;
            lenB--;
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }
}