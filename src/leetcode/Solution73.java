package leetcode;

public class Solution73 {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length < 1) {
            return;
        }

        int r = matrix.length;
        int c = matrix[0].length;

        boolean firstRowToZero = false;
        boolean firstColToZero = false;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        firstRowToZero = true;
                    }
                    if (j == 0) {
                        firstColToZero = true;
                    }
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (firstRowToZero) {
            for (int i = 0; i < c; i++) {
                matrix[0][i] = 0;
            }
        }

        if (firstColToZero) {
            for (int i = 0; i < r; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}