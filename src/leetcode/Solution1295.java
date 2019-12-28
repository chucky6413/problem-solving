package leetcode;

public class Solution1295 {
	public int findNumbers(int[] nums) {
		int res = 0;
		for (int num : nums) {
			if (String.valueOf(num).length() % 2 == 0) {
				res++;
			}
		}
		return res;
	}
}