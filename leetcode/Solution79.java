public class Solution79 {
    private static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private static boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }

        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int l) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(l) || visited[i][j]) {
            return false;
        }
        if (word.length() == l + 1) {
            return true;
        }

        visited[i][j] = true;
        for (int[] dir : dirs) {
            int r = i + dir[0];
            int c = j + dir[1];

            if (dfs(board, word, r, c, l + 1)) {
                return true;
            }
        }
        visited[i][j] = false;
        return false;
    }
}