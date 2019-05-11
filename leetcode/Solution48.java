public class Solution48 {
    /**
     * clockwise rotate
     * 1. reverse up to down
     * 2. swap the symmetry
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // reverse up to down
        for (int i = 0; i < n; i++) {
            reverseUpToDown(matrix, i);
        }
        // swap the symmetry
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                swap(matrix, new int[]{i, j}, new int[]{j, i});
            }
        }
    }

    private void swap(int[][] matrix, int[] a, int[] b) {
        int tmp = matrix[a[0]][a[1]];
        matrix[a[0]][a[1]] = matrix[b[0]][b[1]];
        matrix[b[0]][b[1]] = tmp;
    }

    private void reverseUpToDown(int[][] matrix, int col) {
        int start = 0, end = matrix.length - 1;
        while (start < end) {
            swap(matrix, new int[]{start, col}, new int[]{end, col});
            start++;
            end--;
        }
    }

//    public void rotate(int[][] matrix) {
//        int n = matrix.length;
//        int depth = 0;
//
//        while (n > 1) {
//            for (int i = 0; i < n - 1; i++) {
//                int r = depth;
//                int c = depth + i;
//
//                int nextInput = matrix[r][c];
//                int save = 0;
//
//                for (int j = 0; j < 4; j++) {
//                    save = matrix[c][matrix.length - 1 - r];
//                    matrix[c][matrix.length - 1 - r] = nextInput;
//                    nextInput = save;
//
//                    int t = r;
//                    r = c;
//                    c = matrix.length - 1 - t;
//                }
//            }
//
//            n -= 2;
//            depth++;
//        }
//    }
}