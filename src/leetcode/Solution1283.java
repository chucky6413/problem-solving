package leetcode;

public class Solution1283 {
	public int smallestDivisor(int[] nums, int threshold) {
		int left = 1;
		int right = (int)1e6;

		while (left < right) {
			int div = (left + right) / 2;

			int sum = 0;
			for (int num : nums) {
				sum += (int)Math.ceil((double)num / div);
			}

			if (sum > threshold) {
				left = div + 1;
			} else {
				right = div;
			}
		}

		return left;
	}
}