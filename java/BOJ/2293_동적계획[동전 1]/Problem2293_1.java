/*
 * 2017.04.02
 * ������ȹ
 * 
 * @problem https://www.acmicpc.net/problem/2293
 * @github https://github.com/chucky6413
 * @author chucky3
 */

import java.util.*;

public class Problem2293_1 {
    static int n, k, sum = 0;
    static int arr[];
    static int dp[][];

    public static void main(String arg[]) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        k = input.nextInt();
        arr = new int[n + 1];
        dp = new int[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = input.nextInt();
        }

        for (int j = 0; j <= k; j++) {
            dp[1][j] = j % arr[1] == 0 ? 1 : 0;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                int m = j - arr[i];
                if (m >= 0) {
                    dp[i][j] = dp[i][m] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[n][k]);
    }
}