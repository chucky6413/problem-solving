package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();

        // right, down, left, up
        int dirs[][] = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int colLength = matrix[0].length;
        int rowLength = matrix.length - 1;

        int[] cur = new int[]{0, -1};

        boolean stop = false;
        while (!stop) {
            for (int i = 0; i < dirs.length; i++) {
                int[] dir = dirs[i];

                int moveCount = i % 2 == 0 ? colLength-- : rowLength--;

                if (moveCount == 0) {
                    stop = true;
                    break;
                }

                while (moveCount-- > 0) {
                    cur[0] += dir[0];
                    cur[1] += dir[1];
                    res.add(matrix[cur[0]][cur[1]]);
                }
            }
        }

        return res;
    }
}