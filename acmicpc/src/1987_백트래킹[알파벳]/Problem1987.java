/*
 * 2017.03.23
 * ��Ʈ��ŷ
 *
 * @problem https://www.acmicpc.net/problem/1987
 * @github https://github.com/chucky6413
 * @author chucky3
 */

import java.util.*;

public class Problem1987 {
    static int R, C, max = 0, count = 0;
    static char arr[][];
    static boolean check[] = new boolean[26];

    public static void main(String arg[]) {
        Scanner input = new Scanner(System.in);
        R = input.nextInt();
        C = input.nextInt();
        arr = new char[R][C];

        for (int i = 0; i < R; i++) {
            arr[i] = input.next().toCharArray();
        }

        solve(0, 0);
        System.out.println(max);
    }

    public static void solve(int x, int y) {
        if (x >= R || y >= C) return;
        if (x < 0 || y < 0) return;

        int alphabet = arr[x][y] - 65;

        if (!check[alphabet]) {
            check[alphabet] = true;
            count++;
            if (count > max) max = count;
        } else {
            return;
        }
        //���� �¿�
        solve(x + 1, y);
        solve(x, y + 1);
        solve(x, y - 1);
        solve(x - 1, y);

        check[alphabet] = false; //���� ����
        count--; //���� ����
    }
}