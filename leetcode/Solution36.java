import java.util.HashSet;
import java.util.Set;

public class Solution36 {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            // check row
            set.clear();
            for (int j = 0; j < 9; j++) {
                if (!isValid(set, board[i][j])) {
                    return false;
                }
            }

            // check column
            set.clear();
            for (int j = 0; j < 9; j++) {
                if (!isValid(set, board[j][i])) {
                    return false;
                }
            }
        }

        // check sub-box
        for (int i = 0; i < 3; i++) {
            int r = i * 3;
            for (int j = 0; j < 3; j++) {
                int c = j * 3;
                set.clear();
                for (int k = r; k < r + 3; k++) {
                    for (int l = c; l < c + 3; l++) {
                        if (!isValid(set, board[k][l])) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    private boolean isValid(Set<Character> set, char c) {
        if (c == '.' || set.add(c)) {
            return true;
        }
        return false;
    }
}