package leetcode;

public class Solution678 {
	private Boolean[][] memo = new Boolean[100][100];

	public boolean checkValidString(String s) {
		return solve(s, 0, 0);
	}

	public boolean solve(String s, int start, int pts) {
		if (pts < 0) {
			return false;
		}

		if (memo[start][pts] != null) {
			return memo[start][pts];
		}

		int cur = pts;
		for (int i = start; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c == '(') {
				cur++;
			} else if (c == ')') {
				if (cur <= 0) {
					memo[start][pts] = false;
					return memo[start][pts];
				}
				cur--;
			} else if (c == '*') {
				memo[start][pts] = solve(s, i + 1, cur + 1)
					|| solve(s, i + 1, cur - 1)
					|| solve(s, i + 1, cur);
				return memo[start][pts];
			}
		}

		memo[start][pts] = cur == 0;
		return memo[start][pts];
	}
}