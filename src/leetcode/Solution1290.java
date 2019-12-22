package leetcode;

import java.util.Stack;

public class Solution1290 {
	public int getDecimalValue(ListNode head) {
		Stack<Integer> stack = new Stack<>();

		while (head != null) {
			stack.push(head.val);
			head = head.next;
		}

		int res = 0;
		int b = 1;
		while (!stack.isEmpty()) {
			res += stack.pop() * b;
			b *= 2;
		}
		return res;
	}
}