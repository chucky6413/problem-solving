package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution1072 {
	public int maxEqualRowsAfterFlips(int[][] matrix) {
		Map<String, Integer> cnt = new HashMap<>();
		for (int i = 0; i < matrix.length; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < matrix[0].length; j++) {
				sb.append(matrix[i][j]);
			}
			String row = sb.toString();
			cnt.put(row, cnt.getOrDefault(row, 0) + 1);
		}

		int rs = 0;
		for (String row : cnt.keySet()) {
			String allDiff = allDiff(row);
			rs = Math.max(cnt.get(row) + cnt.getOrDefault(allDiff, 0), rs);
		}
		return rs;
	}

	private String allDiff(String row) {
		StringBuilder sb = new StringBuilder();
		for (char c : row.toCharArray()) {
			if (c == '1') {
				sb.append('0');
			} else {
				sb.append('1');
			}
		}
		return sb.toString();
	}
}