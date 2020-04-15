package leetcode;

/**
 * crazy solution
 * https://leetcode.com/problems/product-of-array-except-self/discuss/65622/Simple-Java-solution-in-O(n)-without-extra-space
 */
public class Solution238 {
	public int[] productExceptSelf(int[] nums) {
		int[] rs = new int[nums.length];

		int product = 1;
		boolean[] isZero = new boolean[nums.length];
		int zeroCnt = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				product *= nums[i];
			} else {
				isZero[i] = true;
				zeroCnt++;
			}
		}

		for (int i = 0; i < nums.length; i++) {
			if ((isZero[i] && zeroCnt > 1)
				|| (!isZero[i] && zeroCnt > 0)) {
				rs[i] = 0;
			} else {
				rs[i] = product / ((nums[i] == 0 ? 1 : nums[i]));
			}
		}

		return rs;
	}
}