package leetcode;

public class Solution740 {
    public int deleteAndEarn(int[] nums) {
        int[] sum = new int[10001];

        for (int num : nums) {
            sum[num] += num;
        }

        int[] dp = new int[10001];
        dp[1] = sum[1];
        for (int i = 2; i <= 10000; i++) {
            dp[i] = Math.max(sum[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[10000];
    }
}