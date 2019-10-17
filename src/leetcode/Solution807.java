package leetcode;

public class Solution807 {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        int[] maxRow = new int[r];
        int[] maxCol = new int[c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                maxRow[i] = Math.max(grid[i][j], maxRow[i]);
                maxCol[j] = Math.max(grid[i][j], maxCol[j]);
            }
        }

        int rs = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int low = Math.min(maxRow[i], maxCol[j]);
                if (grid[i][j] < low) {
                    rs += low - grid[i][j];
                }
            }
        }
        return rs;
    }
}