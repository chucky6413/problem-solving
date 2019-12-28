package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution1296 {
	public boolean isPossibleDivide(int[] nums, int k) {
		int n = nums.length;
		if (n % k != 0) {
			return false;
		}

		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		Arrays.sort(nums);
		for (int num : nums) {
			if (map.get(num) > 0) {
				for (int i = 0; i < k; i++) {
					int next = num + i;
					if (map.containsKey(next) && map.get(next) > 0) {
						map.put(next, map.get(next) - 1);
					} else {
						return false;
					}
				}
			}
		}
		return true;
	}
}