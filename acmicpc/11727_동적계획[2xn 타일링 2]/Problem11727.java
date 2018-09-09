/*
 * 2017.01.18
 * ���� ��ȹ
 *
 * dp[i-1] 1X2�� ä��� �� + dp[i-2] 2X1�� ä��� �� + dp[i-2] 2X2�� ä��� ��
 * @problem https://www.acmicpc.net/problem/11727
 * @github https://github.com/chucky6413
 * @author chucky3
 */

import java.util.*;

public class Problem11727 {
    static int dp[];

    public static void main(String arg[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        dp = new int[n + 1];
        if (n > 0) dp[1] = 1;
        if (n > 1) dp[2] = 3;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 10007;
        }

        System.out.println(dp[n]);
    }
}