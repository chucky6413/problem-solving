package leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution1368 {
	public int minCost(int[][] grid) {
		final int m = grid.length;
		final int n = grid[0].length;

		Queue<Cell> q = new PriorityQueue<>();
		boolean[][] visited = new boolean[m][n];
		q.offer(new Cell(0, 0, 0));

		int[][] dirs = new int[][] {{0, 0}, {0, 1}, {0, -1}, {1, 0}, {-1, 0}};

		while (!q.isEmpty()) {
			Cell c = q.poll();
			if (c.r == m - 1 && c.c == n - 1) {
				return c.cost;
			}
			if (visited[c.r][c.c]) {
				continue;
			}
			visited[c.r][c.c] = true;

			for (int i = 1; i < dirs.length; i++) {
				int nr = c.r + dirs[i][0];
				int nc = c.c + dirs[i][1];

				if (nr < 0 || nc < 0 || nr >= m || nc >= n) {
					continue;
				}
				int nextCost = c.cost + (grid[c.r][c.c] == i ? 0 : 1);
				q.offer(new Cell(nr, nc, nextCost));
			}
		}

		return -1;
	}

	class Cell implements Comparable<Cell> {
		int r;
		int c;
		int cost;

		public Cell(int r, int c, int cost) {
			this.r = r;
			this.c = c;
			this.cost = cost;
		}

		@Override
		public int compareTo(Cell other) {
			return cost - other.cost;
		}
	}
}