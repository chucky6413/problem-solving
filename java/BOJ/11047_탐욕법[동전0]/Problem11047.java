/*
 * 2017.04.03
 * Ž���
 * 
 * @problem https://www.acmicpc.net/problem/11047
 * @github https://github.com/chucky6413
 * @author chucky3
 */

import java.util.*;

public class Problem11047 {
    static int n, k;
    static int count = 0, div = 0;
    static int arr[] = new int[11];

    public static void main(String arg[]) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        k = input.nextInt();
        for (int i = 1; i <= n; i++) {
            arr[i] = input.nextInt();
        }
        for (int i = n; i > 0; i--) {
            count += k / arr[i];
            div = k / arr[i];
            if (div != 0) {
                k %= arr[i];
            }
            if (k == 0) break;
        }
        System.out.println(count);
    }
}