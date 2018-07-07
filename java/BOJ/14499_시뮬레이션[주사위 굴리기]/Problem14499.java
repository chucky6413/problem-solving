/*
 * 2017.04.19
 * �ùķ��̼�
 * 
 * @problem https://www.acmicpc.net/problem/14499
 * @github https://github.com/chucky6413
 * @author chucky3
 */

import java.util.*;
import java.io.*;

public class Problem14499 {
    static int n, m;
    static int x, y, k;
    static int six[][] = new int[4][3];
    static int value[] = new int[6];
    static int arr[][];
    static int order[];
    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {1, -1, 0, 0};
    static final String NEWLINE = "\n";

    public static void main(String arg[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String temp[];

        temp = br.readLine().split(" ");
        n = Integer.parseInt(temp[0]);
        m = Integer.parseInt(temp[1]);
        x = Integer.parseInt(temp[2]);
        y = Integer.parseInt(temp[3]);
        k = Integer.parseInt(temp[4]);
        arr = new int[n][m];
        order = new int[k];
        init();
        for (int i = 0; i < n; i++) {
            temp = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(temp[j]);
            }
        }
        temp = br.readLine().split(" ");
        for (int i = 0; i < k; i++) {
            order[i] = Integer.parseInt(temp[i]);

            int tx, ty;
            tx = x + dx[order[i] - 1];
            ty = y + dy[order[i] - 1];
            if (inner(tx, ty)) {
                x = tx;
                y = ty;
                change(order[i]);
                if (arr[x][y] == 0) {
                    arr[x][y] = value[six[3][1] - 1];
                } else {
                    value[six[3][1] - 1] = arr[x][y];
                    arr[x][y] = 0;
                }
                sb.append(value[six[1][1] - 1] + NEWLINE);
            }
        }
        System.out.println(sb);
        br.close();
    }

    public static boolean inner(int x, int y) {
        if (x < 0 || x > n - 1 || y < 0 || y > m - 1) {
            return false;
        }
        return true;
    }

    public static void init() {
        six[0][1] = 2;
        six[1][0] = 4;
        six[1][1] = 1;
        six[1][2] = 3;
        six[2][1] = 5;
        six[3][1] = 6;
    }

    public static void change(int dir) {
        int temp[][] = new int[4][3];
        if (dir == 1) {// ��
            temp[0][1] = six[0][1];
            temp[1][0] = six[3][1];
            temp[1][1] = six[1][0];
            temp[1][2] = six[1][1];
            temp[2][1] = six[2][1];
            temp[3][1] = six[1][2];
        } else if (dir == 2) {// ��
            temp[0][1] = six[0][1];
            temp[1][0] = six[1][1];
            temp[1][1] = six[1][2];
            temp[1][2] = six[3][1];
            temp[2][1] = six[2][1];
            temp[3][1] = six[1][0];
        } else if (dir == 3) {// ��
            temp[0][1] = six[1][1];
            temp[1][0] = six[1][0];
            temp[1][1] = six[2][1];
            temp[1][2] = six[1][2];
            temp[2][1] = six[3][1];
            temp[3][1] = six[0][1];
        } else if (dir == 4) {// ��
            temp[0][1] = six[3][1];
            temp[1][0] = six[1][0];
            temp[1][1] = six[0][1];
            temp[1][2] = six[1][2];
            temp[2][1] = six[1][1];
            temp[3][1] = six[2][1];
        }
        six = temp.clone();
    }
}