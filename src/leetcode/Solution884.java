package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution884 {
	public String[] uncommonFromSentences(String A, String B) {
		Map<String, Integer> cnt = new HashMap<>();
		for (String word : (A + " " + B).split(" ")) {
			cnt.put(word, cnt.getOrDefault(word, 0) + 1);
		}
		List<String> res = new ArrayList<>();
		for (String key : cnt.keySet()) {
			if (cnt.get(key) == 1) {
				res.add(key);
			}
		}
		return res.toArray(new String[0]);
	}
}