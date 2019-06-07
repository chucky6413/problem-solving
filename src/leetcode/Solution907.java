package leetcode;

import java.util.Stack;

public class Solution907 {
    public int sumSubarrayMins(int[] A) {
        int res = 0;
        int MOD = 1_000_000_007;

        Stack<SameValueSet> stack = new Stack<>();
        int sumOfCurrentStack = 0;

        for (int i = 0; i < A.length; i++) {
            int tempCount = 0;

            while (!stack.isEmpty() && stack.peek().getValue() > A[i]) {
                SameValueSet svs = stack.pop();
                tempCount += svs.getCount();
                sumOfCurrentStack -= svs.getValue() * svs.getCount();
            }

            stack.push(new SameValueSet(A[i], tempCount + 1));
            sumOfCurrentStack += (stack.peek().getValue() * stack.peek().getCount());
            res = (res + sumOfCurrentStack) % MOD;
        }

        return res;
    }
}

class SameValueSet {
    private int value;
    private int count;

    public SameValueSet(int value, int count) {
        this.value = value;
        this.count = count;
    }

    public int getValue() {
        return value;
    }

    public int getCount() {
        return count;
    }
}