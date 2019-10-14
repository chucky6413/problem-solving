package leetcode;

public class Solution1219 {
    private static final int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int M, N, res = Integer.MIN_VALUE;

    public int getMaximumGold(int[][] grid) {
        M = grid.length;
        N = grid[0].length;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                findMax(grid, i, j, 0);
            }
        }
        return res;
    }

    private void findMax(int[][] grid, int r, int c, int cur) {
        if (r < 0 || r >= M || c < 0 || c >= N || grid[r][c] == 0) {
            return;
        }

        int gold = grid[r][c];
        cur = cur + gold;
        res = Math.max(cur, res);
        grid[r][c] = 0; // visit
        for (int[] dir : dirs) {
            findMax(grid, r + dir[0], c + dir[1], cur);
        }
        grid[r][c] = gold; // reset
    }
}