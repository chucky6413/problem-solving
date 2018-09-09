/*
 * @problem https://leetcode.com/problems/game-of-life/description/
 * @author chucky6413
 */

public class Solution289 {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {

                int liveNCount = getLiveNeighborsCount(board, row, col);

                if (board[row][col] == 1) {
                    if (liveNCount == 2 || liveNCount == 3) {
                        board[row][col] = 3; // make last bit 1 => 11
                    }
                } else {
                    if (liveNCount == 3) {
                        board[row][col] = 2; // make last bit 1 => 10
                    }
                }

            }
        }

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                board[row][col] >>= 1;
            }
        }
    }

    public int getLiveNeighborsCount(int board[][], int row, int col) {
        int count = 0;

        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i >= 0 && i < board.length && j >= 0 && j < board[0].length) {
                    count += board[i][j] & 1;
                }
            }
        }

        return count - (board[row][col] & 1);
    }
}