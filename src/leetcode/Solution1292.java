package leetcode;

public class Solution1292 {
	public int maxSideLength(int[][] mat, int threshold) {
		int res = 0;

		int m = mat.length;
		int n = mat[0].length;
		int[][] prefixSum = new int[m + 1][n + 1];
		for (int r = 1; r <= m; r++) {
			int sum = 0;
			for (int c = 1; c <= n; c++) {
				sum += mat[r - 1][c - 1];
				prefixSum[r][c] = prefixSum[r - 1][c] + sum;
			}
		}

		int possMaxLen = Math.min(m, n);
		for (int l = 1; l <= possMaxLen; l++) {
			for (int r = 1; r + l <= m; r++) {
				for (int c = 1; c + l <= n; c++) {
					int sqSum = prefixSum[r + l][c + l]
						- prefixSum[r + l][c - 1] - prefixSum[r - 1][c + l] + prefixSum[r - 1][c - 1];

					if (sqSum <= threshold) {
						res = l + 1;
					}
				}
			}
		}

		return res;
	}
}