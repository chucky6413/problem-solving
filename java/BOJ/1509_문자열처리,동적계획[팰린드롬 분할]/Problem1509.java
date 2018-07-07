/*
 * 2017.04.08
 * ���ڿ� ó��, ������ȹ
 * 
 * @problem https://www.acmicpc.net/problem/1509
 * @github https://github.com/chucky6413
 * @author chucky3
 */

import java.util.*;

public class Problem1509 {
    static int dp[][] = new int[2500][2500];
    static int result[] = new int[2500];
    static char str[] = new char[2500];

    public static void main(String arg[]) {
        Scanner input = new Scanner(System.in);
        str = input.nextLine().toCharArray();
        int size = str.length;

        for (int i = 0; i < size; i++) {
            dp[i][i] = 1;
        }

        for (int i = 0; i < size - 1; i++) {
            if (str[i] == str[i + 1]) {
                dp[i][i + 1] = 1;
            }
        }

        for (int i = 2; i < size; i++) {
            for (int j = 0; i + j < size; j++) {
                if (str[j] == str[i + j] && dp[j + 1][i + j - 1] == 1) {
                    dp[j][j + i] = 1;
                }
            }
        }

        for (int i = 0; i < size; i++) {
            if (i == 0)
                result[i] = 1;
            else if ((result[i] != 0 && result[i] > result[i - 1] + 1) || result[i] == 0)
                result[i] = result[i - 1] + 1;

            for (int j = i + 1; j < size; j++) {
                if (dp[i][j] != 0) {
                    if ((result[j] != 0 && result[j] > result[i - 1] + 1) || result[j] == 0) {
                        result[j] = i == 0 ? 1 : result[i - 1] + 1;
                    }
                }
            }
        }
        System.out.println(result[size - 1]);
    }
}