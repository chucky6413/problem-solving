/*
 * 2017.04.19
 * ������ȹ
 *
 * @problem https://www.acmicpc.net/problem/14501
 * @github https://github.com/chucky6413
 * @author chucky3
 */

import java.util.*;
import java.io.*;

public class Problem14501 {
    static int n;
    static int arr[][];
    static int dp[];

    public static void main(String arg[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp[];

        n = Integer.parseInt(br.readLine());
        arr = new int[n][2];
        dp = new int[n];
        for (int i = 0; i < n; i++) {
            temp = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(temp[0]);
            arr[i][1] = Integer.parseInt(temp[1]);
        }
        for (int i = 0; i < n; i++) {
            if (i + arr[i][0] <= n && dp[i] == 0)
                dp[i] = arr[i][1];
            for (int j = i + arr[i][0]; j < n; j++) {
                if (j + arr[j][0] <= n)
                    dp[j] = Math.max(dp[i] + arr[j][1], dp[j]);
                else
                    dp[j] = dp[i];
            }
        }
        Arrays.sort(dp);
        System.out.println(dp[n - 1]);
    }
}