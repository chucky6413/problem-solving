package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution1324 {
	private static final String SPACE = " ";

	public List<String> printVertically(String s) {
		String[] words = s.split(SPACE);
		int maxLen = 0;
		for (String word : words) {
			maxLen = Math.max(word.length(), maxLen);
		}

		List<String> rs = new ArrayList<>();
		for (int i = 0; i < maxLen; i++) {
			StringBuilder sb = new StringBuilder();
			int lastAlphabetIdx = 0;
			for (String word : words) {
				if (i < word.length()) {
					lastAlphabetIdx = sb.length();
					sb.append(word.charAt(i));
				} else {
					sb.append(SPACE);
				}
			}
			sb.delete(lastAlphabetIdx + 1, sb.length());
			rs.add(sb.toString());
		}

		return rs;
	}
}