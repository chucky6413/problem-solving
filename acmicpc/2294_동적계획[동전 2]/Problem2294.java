/*
 * 2017.04.02
 * ������ȹ
 * 
 * @problem https://www.acmicpc.net/problem/2294
 * @github https://github.com/chucky6413
 * @author chucky3
 */

import java.util.*;

public class Problem2294 {
    static int n, k;
    static int arr[] = new int[101];
    static int dp[] = new int[10001];

    public static void main(String arg[]) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        k = input.nextInt();

        for (int i = 1; i <= n; i++) {
            arr[i] = input.nextInt();
        }
        Arrays.fill(dp, 10001);
        for (int i = 1; i <= n; i++) {
            if (arr[i] > 10000) continue; //���� .. �־����� ������ ��ġ�� 10000���϶��� ���ߴ�..
            dp[arr[i]] = 1; //1�� �ּڰ� �̹Ƿ�
            for (int j = arr[i]; j <= k; j++) {
                dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
            }
        }
        //System.out.println(Arrays.toString(dp));

        System.out.println(dp[k] == 10001 ? -1 : dp[k]);
    }
}