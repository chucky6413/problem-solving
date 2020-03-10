package leetcode;

public class Solution171 {
	public int titleToNumber(String s) {
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			int v = (s.charAt(i) - 'A') + 1;
			res += v * Math.pow(26, (s.length() - i - 1));
		}
		return res;
	}
}