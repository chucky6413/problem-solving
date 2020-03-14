package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution448 {
	public List<Integer> findDisappearedNumbers(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			int val = Math.abs(nums[i]) - 1;
			if (nums[val] > 0) {
				nums[val] = -nums[val];
			}
		}

		List<Integer> rs = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				rs.add(i + 1);
			}
		}
		return rs;
	}
}