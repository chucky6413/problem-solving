/*
 * 2017.04.23
 * ������ȹ
 * 
 * @problem https://www.acmicpc.net/problem/1010
 * @github https://github.com/chucky6413
 * @author chucky3
 */

import java.io.*;
import java.util.*;

public class Problem1010 {
    static int t, n, m;
    static int dp[][];
    static final String NEWLINE = "\n";

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String temp[];

        t = Integer.parseInt(br.readLine());
        dp = new int[31][31];
        for (int i = 1; i <= 30; i++) {
            for (int j = 1; j <= 30; j++) {
                if (j == 1) dp[i][j] = i;
                else dp[i][j] = (dp[i][j - 1] * (i - j + 1)) / j;
            }
        }

        for (int i = 0; i < t; i++) { //���
            temp = br.readLine().split(" ");
            n = Integer.parseInt(temp[0]);
            m = Integer.parseInt(temp[1]);
            sb.append(dp[m][n] + NEWLINE);
        }
        br.close();
        System.out.println(sb);
    }
}
