package leetcode;

import java.util.Stack;

public class Solution1209 {
    class Pair {
        char c;
        int cnt;

        public Pair(char c, int cnt) {
            this.c = c;
            this.cnt = cnt;
        }
    }

    public String removeDuplicates(String s, int k) {
        Stack<Pair> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek().c == c) {
                stack.push(new Pair(c, stack.peek().cnt + 1));
            } else {
                stack.push(new Pair(c, 1));
            }

            if (stack.peek().cnt == k) {
                for (int i = 0; i < k; i++) {
                    stack.pop();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop().c);
        }
        return sb.reverse().toString();
    }
}