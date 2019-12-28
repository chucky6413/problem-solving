package leetcode;

import java.util.Arrays;

public class Solution1293 {
	private static int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	private int m, n, mn;
	private int[][][] memo;
	private boolean[][] visited;

	public int shortestPath(int[][] grid, int k) {
		m = grid.length;
		n = grid[0].length;
		mn = m * n;
		memo = new int[m][n][mn + 1];
		fill(memo, -1);
		visited = new boolean[m][n];
		int res = dfs(0, 0, k, grid);
		return res == mn ? -1 : res;
	}

	private int dfs(int r, int c, int k, int[][] grid) {
		if (r == m - 1 && c == n - 1) {
			return 0;
		} else if (memo[r][c][k] != -1) {
			return memo[r][c][k];
		}

		int res = mn;
		visited[r][c] = true;
		for (int[] dir : dirs) {
			int y = r + dir[0];
			int x = c + dir[1];

			if (isValid(y, x) && !visited[y][x]) {
				if (grid[y][x] == 0) {
					res = Math.min(dfs(y, x, k, grid) + 1, res);
				} else if (k > 0) {
					res = Math.min(dfs(y, x, k - 1, grid) + 1, res);
				}
			}
		}
		memo[r][c][k] = res;
		visited[r][c] = false;
		return res;
	}

	private void fill(int[][][] arr, int value) {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				Arrays.fill(arr[i][j], value);
			}
		}
	}

	private boolean isValid(int y, int x) {
		return ((y >= 0 && y < m)
			&& (x >= 0 && x < n));
	}
}