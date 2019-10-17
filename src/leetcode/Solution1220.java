package leetcode;

public class Solution1220 {
    public int countVowelPermutation(int n) {
        int MOD = 1_000_000_007;
        long[][] dp = new long[n + 1][5];

        for (int j = 0; j < 5; j++) {
            dp[1][j] = 1;
        }

        for (int i = 2; i <= n; i++) {
            dp[i][0] = (dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][4]) % MOD;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD;
            dp[i][2] = (dp[i - 1][1] + dp[i - 1][3]) % MOD;
            dp[i][3] = (dp[i - 1][2]) % MOD;
            dp[i][4] = (dp[i - 1][2] + dp[i - 1][3]) % MOD;
        }

        long rs = 0;
        for (long c : dp[n]) {
            rs += c;
            rs %= MOD;
        }
        return (int) rs;
    }
}