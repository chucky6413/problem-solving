package leetcode;

public class Solution1400 {
	public boolean canConstruct(String s, int k) {
		int odd = 0;
		int n = s.length();
		boolean[] isOdd = new boolean[26];
		for (int i = 0; i < n; i++) {
			int idx = s.charAt(i) - 'a';
			isOdd[idx] = !isOdd[idx];
			odd += isOdd[idx] ? 1 : -1;
		}
		return odd <= k && k <= n;
	}
}