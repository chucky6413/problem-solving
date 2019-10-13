package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1222 {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        boolean[][] isQueen = new boolean[8][8];
        for (int i = 0; i < queens.length; i++) {
            isQueen[queens[i][0]][queens[i][1]] = true;
        }

        List<List<Integer>> rs = new ArrayList<>();
        int[][] dirs = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0},
                {-1, -1}, {-1, 1}, {1, 1}, {1, -1}};
        for (int[] dir : dirs) {
            List<Integer> queen = getAttackableQueen(isQueen, king, dir);
            if (queen != null) {
                rs.add(queen);
            }
        }
        return rs;
    }

    private List<Integer> getAttackableQueen(boolean[][] isQueen, int[] king, int[] dir) {
        int r = king[0] + dir[0];
        int c = king[1] + dir[1];

        while ((r >= 0 && r < 8) && (c >= 0 && c < 8)) {
            if (isQueen[r][c]) return Arrays.asList(r, c);
            r += dir[0];
            c += dir[1];
        }
        return null;
    }
}