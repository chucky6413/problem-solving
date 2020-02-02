package leetcode;

public class Solution1335 {
	public int minDifficulty(int[] jobDifficulty, int d) {
		int len = jobDifficulty.length;
		if (d > len) {
			return -1;
		}
		int[][] dp = new int[d][len];
		dp[0][0] = jobDifficulty[0];
		for (int i = 1; i < len; i++) {
			dp[0][i] = Math.max(jobDifficulty[i], dp[0][i - 1]);
		}

		for (int di = 1; di < d; di++) {
			for (int i = di; i < len; i++) {
				int max = jobDifficulty[i];
				dp[di][i] = Integer.MAX_VALUE;
				for (int j = i; j >= di; j--) {
					max = Math.max(jobDifficulty[j], max);
					dp[di][i] = Math.min(dp[di - 1][j - 1] + max, dp[di][i]);
				}
			}
		}

		return dp[d - 1][len - 1];
	}
}