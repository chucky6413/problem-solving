package leetcode;

public class Solution213 {
	public int rob(int[] nums) {
		if (nums.length == 0) {
			return 0;
		} else if (nums.length == 1) {
			return nums[0];
		}

		return Math.max(solve(nums, 0, nums.length - 2),
			solve(nums, 1, nums.length - 1));
	}

	private int solve(int[] nums, int start, int end) {
		int[] dp = new int[nums.length];
		for (int i = start; i <= end; i++) {
			dp[i] = Math.max(getVal(dp, i - 2, start) + nums[i], getVal(dp, i - 1, start));
		}
		return dp[end];
	}

	private int getVal(int[] arr, int idx, int start) {
		if (idx < start) {
			return 0;
		} else {
			return arr[idx];
		}
	}
}