package leetcode;

import java.util.Stack;

public class Solution32 {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int[] d = new int[s.length()];

        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(i);
            } else if (c == ')' && !stack.isEmpty()) {
                int index = stack.pop();
                d[i] = (i - index + 1);
                if (index != 0) d[i] += d[index - 1];
                max = Math.max(max, d[i]);
            }
        }

        return max;
    }
}
