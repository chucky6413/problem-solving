package leetcode;

public class Solution1252 {
    public int oddCells(int n, int m, int[][] indices) {
        int[][] cells = new int[n][m];

        for (int[] idc : indices) {
            int ri = idc[0];
            int ci = idc[1];
            for (int c = 0; c < m; c++) {
                cells[ri][c]++;
            }
            for (int r = 0; r < n; r++) {
                cells[r][ci]++;
            }
        }

        int odd = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (cells[r][c] % 2 == 1) {
                    odd++;
                }
            }
        }
        return odd;
    }
}