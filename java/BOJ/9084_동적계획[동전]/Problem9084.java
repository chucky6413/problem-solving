/*
 * 2017.04.02
 * ������ȹ
 * 
 * @problem https://www.acmicpc.net/problem/9084
 * @github https://github.com/chucky6413
 * @author chucky3
 */

import java.util.*;

public class Problem9084 {
    static int T, n, k;
    static int arr[] = new int[21];
    static int dp[] = new int[10001];

    public static void main(String arg[]) {
        Scanner input = new Scanner(System.in);
        T = input.nextInt();

        while (T-- > 0) {
            n = input.nextInt(); //���� ����
            for (int i = 1; i <= n; i++) {
                arr[i] = input.nextInt(); //���� �Է�
            }
            k = input.nextInt(); //��ǥ �ݾ�
            Arrays.fill(dp, 0);
            dp[0] = 1;
            for (int i = 1; i <= n; i++) {
                for (int j = arr[i]; j <= k; j++) {
                    dp[j] += dp[j - arr[i]];
                }
            }
            System.out.println(dp[k]);
        }
    }
}