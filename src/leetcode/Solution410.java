package leetcode;

public class Solution410 {
	public int splitArray(int[] nums, int m) {
		int max = 0;
		int sum = 0;

		for (int num : nums) {
			max = Math.max(num, max);
			sum += num;
		}
		if (m == 1) {
			return sum;
		}

		int l = max;
		int r = sum;

		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (valid(nums, m, mid)) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return l;
	}

	private boolean valid(int[] nums, int m, int target) {
		int cnt = 1;
		int cur = 0;

		for (int num : nums) {
			cur += num;
			if (cur > target) {
				cnt++;
				cur = num;

				if (cnt > m) {
					return false;
				}
			}
		}
		return true;
	}
}
