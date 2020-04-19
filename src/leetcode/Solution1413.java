package leetcode;

public class Solution1413 {
	public int minStartValue(int[] nums) {
		int sum = 0, minSum = 0;
		for (int num : nums) {
			sum += num;
			minSum = Math.min(minSum, sum);
		}
		return -minSum + 1;
	}
}