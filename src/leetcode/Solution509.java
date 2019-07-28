package leetcode;

public class Solution509 {
    public int fib(int N) {
        int[] fibo = new int[31];
        fibo[1] = 1;

        for (int i = 2; i <= 30; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }

        return fibo[N];
    }
}