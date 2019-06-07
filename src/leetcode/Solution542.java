package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution542 {
    public int[][] updateMatrix(int[][] matrix) {
        int rLength = matrix.length;
        int cLength = matrix[0].length;

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rLength; i++) {
            for (int j = 0; j < cLength; j++) {
                if (matrix[i][j] == 0) {
                    queue.add(new int[]{i, j});
                } else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        bfs(matrix, queue);

        return matrix;
    }

    private void bfs(int[][] matrix, Queue<int[]> queue) {
        int rLength = matrix.length;
        int cLength = matrix[0].length;

        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int[] node = queue.poll();

            for (int[] dir : dirs) {
                int rIndex = node[0] + dir[0];
                int cIndex = node[1] + dir[1];

                if (rIndex < 0 || rIndex >= rLength || cIndex < 0 || cIndex >= cLength) {
                    continue;
                }

                if (matrix[rIndex][cIndex] <= matrix[node[0]][node[1]]) {
                    continue;
                }

                matrix[rIndex][cIndex] = matrix[node[0]][node[1]] + 1;
                queue.add(new int[]{rIndex, cIndex});
            }
        }
    }
}