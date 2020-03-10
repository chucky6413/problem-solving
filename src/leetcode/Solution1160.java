package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution1160 {
	private final Map<Character, Integer> charsMap = new HashMap<>();

	public int countCharacters(String[] words, String chars) {
		for (char c : chars.toCharArray()) {
			charsMap.put(c, charsMap.getOrDefault(c, 0) + 1);
		}
		int res = 0;
		for (String word : words) {
			if (canBeFormed(word)) {
				res += word.length();
			}
		}

		return res;
	}

	private boolean canBeFormed(String word) {
		Map<Character, Integer> usedChars = new HashMap<>();

		for (char c : word.toCharArray()) {
			int usedCnt = usedChars.getOrDefault(c, 0);
			if (usedCnt >= charsMap.getOrDefault(c, 0)) {
				return false;
			}
			usedChars.put(c, usedCnt + 1);
		}
		return true;
	}
}