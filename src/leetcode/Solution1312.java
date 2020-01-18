package leetcode;

public class Solution1312 {
	public int minInsertions(String s) {
		int n = s.length();

		int[][] lcs = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (s.charAt(i - 1) == s.charAt(s.length() - j)) {
					lcs[i][j] = lcs[i - 1][j - 1] + 1;
				} else {
					lcs[i][j] = Math.max(lcs[i][j - 1], lcs[i - 1][j]);
				}
			}
		}

		return s.length() - lcs[n][n];
	}
}