package leetcode;

import java.util.Stack;

public class Solution1309 {
	public String freqAlphabets(String s) {
		Stack<String> stack = new Stack<>();

		for (char c : s.toCharArray()) {
			if (c == '#') {
				String second = stack.pop();
				String first = stack.pop();
				stack.push(first + second);
			} else {
				stack.push(c + "");
			}
		}

		StringBuilder rs = new StringBuilder();
		while (!stack.isEmpty()) {
			rs.append((char)(Integer.parseInt(stack.pop()) + 96));
		}
		return rs.reverse().toString();
	}
}