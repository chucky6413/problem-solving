package leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution804 {
	private static final String[] morseCodes = new String[] {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....",
		"..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
		"-.--", "--.."};

	public int uniqueMorseRepresentations(String[] words) {
		Set<String> uniq = new HashSet<>();

		for (String word : words) {
			uniq.add(word.chars()
				.mapToObj(c -> morseCodes[c - 'a'])
				.collect(Collectors.joining()));
		}

		return uniq.size();
	}
}