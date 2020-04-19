package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution1415 {
	public String getHappyString(int n, int k) {
		List<String> results = new ArrayList<>();
		StringBuilder cur = new StringBuilder();
		for (char c = 'a'; c <= 'c'; c++) {
			cur.append(c);
			dfs(cur, results, n);
			cur.deleteCharAt(cur.length() - 1);
		}

		return results.size() >= k ? results.get(k - 1) : "";
	}

	private void dfs(StringBuilder cur, List<String> results, int n) {
		if (cur.length() == n) {
			results.add(cur.toString());
			return;
		}

		for (char c = 'a'; c <= 'c'; c++) {
			if (cur.charAt(cur.length() - 1) != c) {
				cur.append(c);
				dfs(cur, results, n);
				cur.deleteCharAt(cur.length() - 1);
			}
		}
	}
}