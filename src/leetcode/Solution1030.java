package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Solution1030 {
	public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
		int[][] cells = new int[R * C][2];

		int idx = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				cells[idx][0] = i;
				cells[idx][1] = j;
				idx++;
			}
		}

		Arrays.sort(cells,
			Comparator.comparingInt(c -> (Math.abs(c[0] - r0) + Math.abs(c[1] - c0))));
		return cells;
	}
}