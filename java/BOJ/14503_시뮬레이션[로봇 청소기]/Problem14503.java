/*
 * 2017.04.19
 * �ùķ��̼�
 *
 * @problem https://www.acmicpc.net/problem/14503
 * @github https://github.com/chucky6413
 * @author chucky3
 */

import java.util.*;
import java.io.*;

public class Problem14503 {
    static int n, m;
    static int x, y, dir;
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};
    static int arr[][];
    static int clean = 0;
    static boolean back = false;

    public static void main(String arg[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp[];

        temp = br.readLine().split(" ");
        n = Integer.parseInt(temp[0]);
        m = Integer.parseInt(temp[1]);

        arr = new int[n][m];

        temp = br.readLine().split(" ");
        x = Integer.parseInt(temp[0]);
        y = Integer.parseInt(temp[1]);
        dir = Integer.parseInt(temp[2]);

        for (int i = 0; i < n; i++) {
            temp = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(temp[j]);
            }
        }

        solve(0);

        System.out.println(clean);
    }

    public static void solve(int cnt) {
        if (back) return;

        if (arr[x][y] == 0) {
            arr[x][y] = 2;
            clean++;
        }

        int tx, ty;
        int backDir = (dir + 2) % 4;
        tx = x + dx[backDir];
        ty = y + dy[backDir];
        if (cnt == 4) {
            if (arr[tx][ty] == 1) {
                back = true;
            } else {
                x = tx;
                y = ty;
                solve(0);
            }
        }

        for (int k = 0; k < 4; k++) {
            dir = (dir + k + 3) % 4;
            tx = x + dx[dir];
            ty = y + dy[dir];
            if (inner(tx, ty) && arr[tx][ty] == 0) {
                x = tx;
                y = ty;
                solve(0);
                return;
            } else {
                solve(cnt + 1);
            }
        }
    }

    public static boolean inner(int x, int y) {
        if (x < 1 || x > n - 2 || y < 1 || y > m - 2) {
            return false;
        }
        return true;
    }
}