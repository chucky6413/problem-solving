package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution1313 {
	public int[] decompressRLElist(int[] nums) {
		List<Integer> dList = new ArrayList<>();
		for (int i = 0; i < nums.length; i += 2) {
			int size = nums[i];
			while (size-- > 0) {
				dList.add(nums[i + 1]);
			}
		}
		return dList.stream()
			.mapToInt(i -> i)
			.toArray();
	}
}