/*
 * 2017.04.23
 * ������ȹ
 * 
 * @problem https://www.acmicpc.net/problem/9465
 * @github https://github.com/chucky6413
 * @author chucky3
 */

import java.io.*;
import java.util.*;

public class Problem9465 {
    static int t, n;
    static int arr[][];
    static int dp[][];
    static final String NEWLINE = "\n";

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String temp[];

        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            arr = new int[2][n];
            dp = new int[2][n];
            for (int i = 0; i < 2; i++) {
                temp = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(temp[j]);
                }
            }
            int max = 0;
            for (int j = 0; j < n; j++) {
                for (int i = 0; i < 2; i++) {
                    if (j == 0) dp[i][j] = arr[i][j];
                    else if (j == 1) dp[i][j] = dp[(i + 1) % 2][j - 1] + arr[i][j];
                    else dp[i][j] = Math.max(dp[(i + 1) % 2][j - 1], dp[(i + 1) % 2][j - 2]) + arr[i][j];
                    max = Math.max(max, dp[i][j]);
                }
            }
            sb.append(max + NEWLINE);
        }
        br.close();
        System.out.println(sb);
    }
}
