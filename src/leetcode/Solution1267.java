package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution1267 {
	private Map<Integer, Integer> rowServerCnt = new HashMap<>();
	private Map<Integer, Integer> colServerCnt = new HashMap<>();

	public int countServers(int[][] grid) {
		int cnt = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					rowServerCnt.put(i, rowServerCnt.getOrDefault(i, 0) + 1);
					colServerCnt.put(j, colServerCnt.getOrDefault(j, 0) + 1);
				}
			}
		}

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					if (isCommunicate(i, j)) {
						cnt++;
					}
				}
			}
		}

		return cnt;
	}

	private boolean isCommunicate(int row, int col) {
		return (rowServerCnt.get(row) > 1 || colServerCnt.get(col) > 1);
	}
}