package leetcode;

public class Solution942 {
	public int[] diStringMatch(String S) {
		int min = 0;
		int max = S.length();

		int[] permutation = new int[S.length() + 1];
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == 'I') {
				permutation[i] = min++;
			} else {
				permutation[i] = max--;
			}
		}
		permutation[S.length()] = max;
		return permutation;
	}
}