package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Solution1307 {
	private static final int[] POW_10 = new int[] {1, 10, 100, 1_000, 10_000, 100_000, 1_000_000};

	public boolean isSolvable(String[] words, String result) {
		Set<Character> charSet = new HashSet<>();
		int[] powSum = new int[91]; //using idx in 65...90(A - Z)
		boolean[] nonLeadingZero = new boolean[91]; //using idx in 65...90(A - Z)

		for (String word : words) {
			char[] cArr = word.toCharArray();
			for (int i = 0; i < cArr.length; i++) {
				if (i == 0 && cArr.length > 1) {
					nonLeadingZero[cArr[i]] = true;
				}
				charSet.add(cArr[i]);
				powSum[cArr[i]] += POW_10[cArr.length - i - 1];
			}
		}

		char[] cArr = result.toCharArray();
		for (int i = 0; i < cArr.length; i++) {
			if (i == 0 && cArr.length > 1) {
				nonLeadingZero[cArr[i]] = true;
			}
			charSet.add(cArr[i]);
			powSum[cArr[i]] -= POW_10[cArr.length - i - 1];
		}

		char[] charList = new char[charSet.size()];
		int idx = 0;
		for (char c : charSet) {
			charList[idx++] = c;
		}
		boolean[] used = new boolean[10];
		return backtracking(charList, used, 0, 0, nonLeadingZero, powSum);
	}

	private boolean backtracking(char[] charList, boolean[] used, int step,
		int diff, boolean[] nonLeadingZero, int[] powSum) {
		if (step == charList.length) {
			return diff == 0;
		}
		for (int d = 0; d <= 9; d++) {
			char c = charList[step];
			if (!used[d] && (d > 0 || !nonLeadingZero[c])) {
				used[d] = true;
				if (backtracking(charList, used, step + 1, diff + d * powSum[c], nonLeadingZero, powSum)) {
					return true;
				}
				used[d] = false;
			}
		}
		return false;
	}
}