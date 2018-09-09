/*
 * 2017.02.06
 * ������ȹ.
 *
 * @problem https://www.acmicpc.net/problem/5721
 * @github https://github.com/chucky6413
 * @author chucky3
 */

import java.io.*;

public class Problem5721 {
    static int m, n;
    static int arr[][]; //candy ���� ���� ����
    static int dp1[][]; //�࿡���� , �� ���� �ִ� ���� ����
    static int dp2[]; //�� ������� �ִ밪

    public static void main(String arg[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String temp[];

        while (true) {
            temp = br.readLine().split(" ");
            m = Integer.parseInt(temp[0]);
            n = Integer.parseInt(temp[1]);

            if (m == 0 && n == 0) {
                break;
            }

            arr = new int[m + 1][n + 1];
            dp1 = new int[m + 1][n + 1];
            dp2 = new int[m + 1];

            for (int i = 1; i <= m; i++) {
                temp = br.readLine().split(" ");
                for (int j = 1; j <= n; j++) {
                    arr[i][j] = Integer.parseInt(temp[j - 1]);

                    if (j < 2) {
                        dp1[i][j] = arr[i][j];
                    } else {
                        dp1[i][j] = Math.max(dp1[i][j - 2] + arr[i][j], dp1[i][j - 1]);
                    }
                }
                if (i < 2) {
                    dp2[i] = dp1[i][n];
                } else {
                    dp2[i] = Math.max(dp2[i - 2] + dp1[i][n], dp2[i - 1]);
                }
            }
            sb.append(dp2[m] + "\n");
        }
        System.out.println(sb.toString());
    }
}