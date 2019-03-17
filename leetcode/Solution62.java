public class Solution62 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[n + 1][m + 1];

        dp[1][1] = 1;

        for (int r = 1; r < n + 1; r++) {
            for (int c = 1; c < m + 1; c++) {
                if (r == 1 && c == 1) {
                    continue;
                }
                dp[r][c] = dp[r - 1][c] + dp[r][c - 1];
            }
        }

        return dp[n][m];
    }
}