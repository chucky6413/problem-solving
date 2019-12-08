package leetcode;

public class Solution1275 {
	private static final char X = 'X';
	private static final char O = 'O';

	public String tictactoe(int[][] moves) {
		char[][] grid = new char[3][3];

		for (int i = 0; i < moves.length; i++) {
			if (i % 2 == 0) {
				grid[moves[i][0]][moves[i][1]] = 'X';
			} else {
				grid[moves[i][0]][moves[i][1]] = 'O';
			}
		}

		return checkResult(moves, grid);
	}

	private String checkResult(int[][] moves, char[][] grid) {
		// check rows, cols
		for (int i = 0; i < 3; i++) {
			int aRowCnt = 0, aColCnt = 0;
			int bRowCnt = 0, bColCnt = 0;

			for (int j = 0; j < 3; j++) {
				if (grid[i][j] == X) {
					aRowCnt++;
				} else if (grid[i][j] == O) {
					bRowCnt++;
				}

				if (grid[j][i] == X) {
					aColCnt++;
				} else if (grid[j][i] == O) {
					bColCnt++;
				}
			}

			if (aRowCnt == 3 || aColCnt == 3) {
				return "A";
			} else if (bRowCnt == 3 || bColCnt == 3) {
				return "B";
			}
		}

		// check diagonals
		if (grid[0][0] == X && grid[1][1] == X && grid[2][2] == X) {
			return "A";
		}
		if (grid[0][0] == O && grid[1][1] == O && grid[2][2] == O) {
			return "B";
		}

		if (grid[2][0] == X && grid[1][1] == X && grid[0][2] == X) {
			return "A";
		}
		if (grid[2][0] == O && grid[1][1] == O && grid[0][2] == O) {
			return "B";
		}

		return moves.length == 9 ? "Draw" : "Pending";
	}
}