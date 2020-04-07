package leetcode;

public class Solution1392 {
	public String longestPrefix(String s) {
		int sameLen = getPi(s);
		return s.substring(0, sameLen);
	}

	private int getPi(String s) {
		int[] pi = new int[s.length()];

		int j = 0;
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == s.charAt(j)) {
				pi[i] = ++j;
			} else if (j > 0) {
				j = pi[j - 1];
				--i;
			}
		}

		return pi[pi.length - 1];
	}
}