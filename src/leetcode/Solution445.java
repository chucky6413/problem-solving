package leetcode;

import java.util.Stack;

/*
 * @problem https://leetcode.com/problems/add-two-numbers-ii/description/
 * @author chucky6413
 */

public class Solution445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rs = new ListNode(0);

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int val = 0;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            val += s1.isEmpty() ? 0 : s1.pop();
            val += s2.isEmpty() ? 0 : s2.pop();

            ListNode node = new ListNode(val % 10);
            node.next = rs.next;
            rs.next = node;
            val /= 10;
        }

        if (val == 1) {
            rs.val = val;
        } else {
            rs = rs.next;
        }

        return rs;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
