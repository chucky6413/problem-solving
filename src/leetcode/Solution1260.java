package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution1260 {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        // m * n = 2,500, k = 100, max loop = 250,000
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < k; i++) {
            int ov = grid[m - 1][n - 1];
            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    int temp = grid[r][c];
                    grid[r][c] = ov;
                    ov = temp;
                }
            }
        }

        List<List<Integer>> rs = new ArrayList<>();
        for (int[] row : grid) {
            List<Integer> sub = new ArrayList<>();
            for (int v : row) {
                sub.add(v);
            }
            rs.add(sub);
        }
        return rs;
    }
}