package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1282 {
	public List<List<Integer>> groupThePeople(int[] groupSizes) {
		List<List<Integer>> groups = new ArrayList<>();

		Map<Integer, List<Integer>> map = new HashMap<>();
		int n = groupSizes.length;
		for (int id = 0; id < n; id++) {
			int size = groupSizes[id];

			if (!map.containsKey(size)) {
				map.put(size, new ArrayList<>());
			}

			map.get(size).add(id);

			if (map.get(size).size() == size) {
				groups.add(map.get(size));
				map.remove(size);
			}
		}

		return groups;
	}
}