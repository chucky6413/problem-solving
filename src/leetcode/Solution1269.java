package leetcode;

public class Solution1269 {
	private static final int MOD = (int)Math.pow(10, 9) + 7;

	public int numWays(int steps, int arrLen) {
		int maxPos = Math.min((steps / 2) + 1, arrLen);

		long[][] dp = new long[steps + 1][maxPos + 1];
		dp[1][0] = 1;
		dp[1][1] = 1;
		for (int s = 2; s <= steps; s++) {
			for (int p = 0; p < maxPos; p++) {
				dp[s][p] = (dp[s - 1][p] + dp[s - 1][p + 1] +
					(p > 0 ? dp[s - 1][p - 1] : 0)) % MOD;
			}
		}

		return (int)dp[steps][0];
	}
}