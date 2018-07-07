/*
 * 2017.01.18
 * ������ȹ
 *
 * @problem https://www.acmicpc.net/problem/2688
 * @github https://github.com/chucky6413
 * @author chucky3
 */

import java.util.Scanner;
import java.util.*;

public class Problem2688 {
    static long dp[][], result[];
    static int answer[], max = 0;

    public static void main(String arg[]) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        answer = new int[t]; //����� ���
        for (int i = 0; i < t; i++) {
            answer[i] = input.nextInt();
            if (max < answer[i])
                max = answer[i];
        }
        dp = new long[max + 1][10];
        for (int i = 0; i <= 9; i++) dp[1][i] = 1; //i�� ���� �� ����� ��
        for (int i = 2; i <= max; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k <= j; k++) {
                    dp[i][j] += dp[i - 1][k]; // dp[i][j] �� dp[i-1][j���� ���� �ֵ���] �� �̴�.
                }
            }
        }

        result = new long[t];
        for (int i = 0; i < t; i++) {
            for (int j = 0; j <= 9; j++) {
                result[i] += dp[answer[i]][j]; //���
            }
            System.out.println(result[i]); //���
        }
    }
}