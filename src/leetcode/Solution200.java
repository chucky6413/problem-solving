package leetcode;

public class Solution200 {
    private static final int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        boolean[][] visit = new boolean[grid.length][grid[0].length];

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visit[i][j] && grid[i][j] == '1') {
                    dfs(i, j, grid, visit);
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(int r, int c, char[][] grid, boolean[][] visit) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || visit[r][c] || grid[r][c] == '0') {
            return;
        }
        visit[r][c] = true;

        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            dfs(nr, nc, grid, visit);
        }
    }
}