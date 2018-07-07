/*
 * 2017.05.22
 * ��Ʈ��ŷ
 * 
 * @problem https://www.acmicpc.net/problem/2580
 * @github https://github.com/chucky6413
 * @author chucky3
 */

import java.util.*;
import java.io.*;

public class Problem2580 {
    static final int n = 9;

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int a[][] = new int[n][n];
        boolean c[][][] = new boolean[3][n][10];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = input.nextInt();
                if (a[i][j] != 0) {
                    c[0][i][a[i][j]] = true;
                    c[1][j][a[i][j]] = true;
                    c[2][square(i, j)][a[i][j]] = true;
                }
            }
        }
        go(a, c, 0);
    }

    public static int square(int x, int y) {
        return (x / 3) * 3 + (y / 3);
    }

    public static boolean go(int a[][], boolean c[][][], int z) {
        if (z == 81) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(a[i][j] + " ");
                }
                System.out.println();
            }
            return true;
        }
        int x = z / n;
        int y = z % n;
        if (a[x][y] != 0) {
            return go(a, c, z + 1);
        } else {
            for (int i = 1; i <= 9; i++) {
                if (!c[0][x][i] && !c[1][y][i] && !c[2][square(x, y)][i]) {
                    c[0][x][i] = c[1][y][i] = c[2][square(x, y)][i] = true;
                    a[x][y] = i;
                    if (go(a, c, z + 1)) {
                        return true;
                    }
                    a[x][y] = 0;
                    c[0][x][i] = c[1][y][i] = c[2][square(x, y)][i] = false;
                }
            }
        }
        return false;
    }
}