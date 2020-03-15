package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1380 {
	public List<Integer> luckyNumbers(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;

		int[] mr = new int[m];
		Arrays.fill(mr, 100_000);
		int[] mc = new int[n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				mr[i] = Math.min(matrix[i][j], mr[i]);
				mc[j] = Math.max(matrix[i][j], mc[j]);
			}
		}

		List<Integer> rs = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (mr[i] == mc[j]) {
					rs.add(mr[i]);
				}
			}
		}
		return rs;
	}
}