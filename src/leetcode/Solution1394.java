package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution1394 {
	public int findLucky(int[] arr) {
		Map<Integer, Integer> cnt = new HashMap<>();
		for (int num : arr) {
			cnt.put(num, cnt.getOrDefault(num, 0) + 1);
		}

		int rs = -1;
		for (int num : arr) {
			if (num == cnt.get(num)) {
				rs = Math.max(num, rs);
			}
		}
		return rs;
	}
}