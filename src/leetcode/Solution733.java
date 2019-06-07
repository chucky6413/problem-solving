package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int targetColor = image[sr][sc];
        image[sr][sc] = newColor;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});

        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()) {
            int[] pixel = queue.poll();

            for (int[] dir : dirs) {
                int r = pixel[0] + dir[0];
                int c = pixel[1] + dir[1];

                if (r < 0 || r >= image.length || c < 0 || c >= image[0].length) {
                    continue;
                }

                if (image[r][c] == targetColor && image[r][c] != newColor) {
                    image[r][c] = newColor;
                    queue.add(new int[]{r, c});
                }
            }
        }

        return image;
    }
}