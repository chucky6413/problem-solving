package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution1424 {
	public int[] findDiagonalOrder(List<List<Integer>> nums) {
		Map<Integer, LinkedList<Integer>> map = new HashMap<>();

		int rowLen = nums.size();
		int colLen = 0;
		int size = 0;
		for (int r = 0; r < nums.size(); r++) {
			for (int c = 0; c < nums.get(r).size(); c++) {
				map.putIfAbsent(r + c, new LinkedList<>());
				map.get(r + c).addFirst(nums.get(r).get(c));
				size++;
			}
			colLen = Math.max(nums.get(r).size(), colLen);
		}

		int[] rs = new int[size];
		int idx = 0;
		for (int key = 0; key <= rowLen + colLen; key++) {
			List<Integer> values = map.get(key);
			if (values != null) {
				for (int value : values) {
					rs[idx++] = value;
				}
			}
		}
		return rs;
	}
}