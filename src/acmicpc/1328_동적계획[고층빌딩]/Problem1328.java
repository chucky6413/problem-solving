/*
 * 2017.06.02
 * ������ȹ
 * 
 * @problem https://www.acmicpc.net/problem/1328
 * @github https://github.com/chucky6413
 * @author chucky3
 */

import java.util.*;

public class Problem1328 {
    static int n, l, r;
    static final int MOD = 1000000007;
    static int dp[][][] = new int[101][101][101];

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        l = input.nextInt();
        r = input.nextInt();

        long temp = 0;

        dp[1][1][1] = 1;
        dp[2][2][1] = dp[2][1][2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i][i][1] = dp[i][1][i] = 1;
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    temp = dp[i - 1][j][k];
                    temp = (temp * (i - 2)) % MOD;
                    temp = (temp + dp[i - 1][j - 1][k]) % MOD;
                    temp = (temp + dp[i - 1][j][k - 1]) % MOD;

                    dp[i][j][k] = (int) temp;
                }
            }
        }
        System.out.println(dp[n][l][r]);
    }
}