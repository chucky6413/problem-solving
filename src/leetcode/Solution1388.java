package leetcode;

public class Solution1388 {
	public int maxSizeSlices(int[] slices) {
		int min = 0;
		for (int i = 1; i < slices.length; i++) {
			if (slices[i] < slices[min]) {
				min = i;
			}
		}
		int[] arr = new int[slices.length];
		for (int i = 0; i < slices.length; i++) {
			arr[i] = slices[(i + min) % slices.length];
		}

		int k = slices.length / 3;
		int[][] dp = new int[arr.length][k + 1];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 1; j <= k; j++) {
				dp[i][j] = Math.max(dp[(i - 1 + dp.length) % dp.length][j],
					dp[(i - 2 + dp.length) % dp.length][j - 1] + arr[i]);
			}
		}
		return dp[dp.length - 1][k];
	}
}