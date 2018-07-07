/*
 * 2017.04.26
 * ������ȹ
 * 
 * @problem https://www.acmicpc.net/problem/1915
 * @github https://github.com/chucky6413
 * @author chucky3
 */

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Problem1915 {
    static int n, m, max = 0;
    static int arr[][];
    static int dp[][];
    static int sd[] = new int[3];

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp[];
        String s;

        temp = br.readLine().split(" ");
        n = Integer.parseInt(temp[0]);
        m = Integer.parseInt(temp[1]);
        arr = new int[n][m];
        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            s = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(s.charAt(j) + "");
            }
        }
        br.close();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(sd, 0);
                if (inner(i - 1, j)) sd[0] = dp[i - 1][j];
                if (inner(i - 1, j - 1)) sd[1] = dp[i - 1][j - 1];
                if (inner(i, j - 1)) sd[2] = dp[i][j - 1];

                if (arr[i][j] == 1 && sd[0] == sd[1] && sd[1] == sd[2]) {
                    dp[i][j] = sd[0] + 1;
                } else if (arr[i][j] == 1) {
                    int min = 1002;
                    for (int k = 0; k < 3; k++) {
                        if (sd[k] < min) {
                            min = sd[k];
                        }
                    }
                    dp[i][j] = min + 1;
                }

                if (dp[i][j] > max) {
                    max = dp[i][j];
                }
            }
        }
        System.out.println(max * max);
    }

    public static boolean inner(int x, int y) {
        if (x < 0 || x > n - 1 || y < 0 || y > m - 1) {
            return false;
        }
        return true;
    }
}
