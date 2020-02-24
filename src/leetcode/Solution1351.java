package leetcode;

public class Solution1351 {
	public int countNegatives(int[][] grid) {
		int cnt = 0;

		for (int[] ints : grid) {
			for (int j = 0; j < grid[0].length; j++) {
				cnt += ints[j] < 0 ? 1 : 0;
			}
		}

		return cnt;
	}
}