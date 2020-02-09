package leetcode;

import java.util.Arrays;

public class Solution1340 {
	public int maxJumps(int[] arr, int d) {
		int[] dp = new int[arr.length];
		Arrays.fill(dp, 1);
		boolean[] visited = new boolean[arr.length];

		int rs = 0;
		for (int i = 0; i < arr.length; i++) {
			rs = Math.max(helper(arr, i, d, dp, visited), rs);
		}
		return rs;
	}

	private int helper(int[] arr, int start, int d, int[] dp, boolean[] visited) {
		if (visited[start]) {
			return dp[start];
		}
		visited[start] = true;

		int left = start;
		while (isValid(start, --left, d, arr)) {
			dp[start] = Math.max(helper(arr, left, d, dp, visited) + 1, dp[start]);
		}

		int right = start;
		while (isValid(start, ++right, d, arr)) {
			dp[start] = Math.max(helper(arr, right, d, dp, visited) + 1, dp[start]);
		}

		return dp[start];
	}

	private boolean isValid(int start, int idx, int d, int[] arr) {
		if (idx < 0 || idx >= arr.length) {
			return false;
		}
		if (Math.abs(start - idx) > d) {
			return false;
		}
		return arr[start] > arr[idx];
	}
}