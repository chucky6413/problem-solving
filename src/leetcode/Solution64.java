package leetcode;

import java.util.Arrays;

public class Solution64 {
	public int minPathSum(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		int[][] dp = new int[n + 1][m + 1];
		for (int[] d : dp) {
			Arrays.fill(d, Integer.MAX_VALUE);
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (i == 0 && j == 0) {
					dp[i + 1][j + 1] = grid[i][j];
				} else {
					dp[i + 1][j + 1] = Math.min(dp[i][j + 1], dp[i + 1][j]) + grid[i][j];
				}
			}
		}

		return dp[n][m];
	}
}