public class Solution463 {
    private final int dirSize = 4;
    private final int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int islandPerimeter(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int rs = 0;

        final int rowSize = grid.length;
        final int colSize = grid[0].length;

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (grid[i][j] == 1) {
                    rs += getSubPerimeterCount(grid, i, j, rowSize, colSize);
                }
            }
        }

        return rs;
    }

    private int getSubPerimeterCount(int[][] grid, int i, int j, int rowSize, int colSize) {
        int count = 0;

        for (int[] d : dir) {
            int row = i + d[0];
            int col = j + d[1];
            if (row < 0 || row >= rowSize || col < 0 || col >= colSize || grid[row][col] == 0) {
                count++;
            }
        }

        return count;
    }
}