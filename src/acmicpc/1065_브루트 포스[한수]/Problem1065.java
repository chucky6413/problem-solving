/*
 * 2017.04.09
 * ���Ʈ ����
 * 
 * @problem https://www.acmicpc.net/problem/1065
 * @github https://github.com/chucky6413
 * @author chucky3
 */

import java.util.*;
import java.io.*;

public class Problem1065 {
    static int n, cnt = 0;

    public static void main(String arg[]) throws IOException {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();

        int arr[] = new int[3]; //3�ڸ� �϶��� Ȯ�ο�.

        for (int i = 1; i <= n; i++) {
            if (i == 1000) break;
            else if (i >= 1 && i < 100) {
                cnt++;
            } else {
                int num = i;
                arr[0] = num / 100;
                num %= 100;
                arr[1] = num / 10;
                num %= 10;
                arr[2] = num;

                if (arr[0] - arr[1] == arr[1] - arr[2])
                    cnt++;
            }
        }
        System.out.println(cnt);
    }
}