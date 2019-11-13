package leetcode;

import java.util.Stack;

public class Solution739 {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int p = stack.pop();
                res[p] = i - p;
            }
            stack.push(i);
        }
        return res;
    }
}