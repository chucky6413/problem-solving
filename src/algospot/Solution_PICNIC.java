package algospot;

import java.util.Scanner;

/**
 * https://algospot.com/judge/problem/read/PICNIC
 */

public class Solution_PICNIC {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();

        StringBuilder rs = new StringBuilder("");
        for (int i = 0; i < tc; i++) {
            int fc = scan.nextInt();
            int cc = scan.nextInt();

            int[][] couples = new int[cc][2];
            for (int j = 0; j < cc; j++) {
                couples[j][0] = scan.nextInt();
                couples[j][1] = scan.nextInt();
            }

            boolean[] isCheck = new boolean[fc];
            rs.append(backtrack(couples, 0, isCheck, fc) + "\n");
        }
        System.out.println(rs.toString());
    }

    private static int backtrack(int[][] couples, int start, boolean[] isCheck, int remainCount) {
        if (remainCount == 0) {
            return 1;
        }

        int cnt = 0;
        for (int i = start; i < couples.length; i++) {
            if (!isCheck[couples[i][0]] && !isCheck[couples[i][1]]) {
                isCheck[couples[i][0]] = isCheck[couples[i][1]] = true;
                cnt += backtrack(couples, i + 1, isCheck, remainCount - 2);
                isCheck[couples[i][0]] = isCheck[couples[i][1]] = false;
            }
        }

        return cnt;
    }
}