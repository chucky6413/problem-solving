public class Solution48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int depth = 0;

        while (n > 1) {
            for (int i = 0; i < n - 1; i++) {
                int r = depth;
                int c = depth + i;

                int nextInput = matrix[r][c];
                int save = 0;

                for (int j = 0; j < 4; j++) {
                    save = matrix[c][matrix.length - 1 - r];
                    matrix[c][matrix.length - 1 - r] = nextInput;
                    nextInput = save;

                    int t = r;
                    r = c;
                    c = matrix.length - 1 - t;
                }
            }

            n -= 2;
            depth++;
        }
    }
}