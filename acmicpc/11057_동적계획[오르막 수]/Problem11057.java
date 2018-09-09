/*
 * 2017.01.19
 * ������ȹ
 *
 * @problem https://www.acmicpc.net/problem/11057
 * @github https://github.com/chucky6413
 * @author chucky3
 */

import java.util.Scanner;
import java.util.*;

public class Problem11057 {
    static long dp[][];
    static int mod = 10007, result = 0;

    public static void main(String arg[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        dp = new long[n + 1][10];
        for (int i = 0; i <= 9; i++) dp[1][i] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k <= j; k++) {
                    dp[i][j] += (dp[i - 1][k] % mod);
                }
            }
        }
        for (int i = 0; i <= 9; i++) {
            result += dp[n][i];
        }
        //���
        System.out.println(result % mod);
    }
}