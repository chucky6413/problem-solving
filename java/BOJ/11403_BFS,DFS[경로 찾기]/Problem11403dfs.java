/*
 * 2017.03.10
 * DFS�� Ǯ��
 *
 * @problem https://www.acmicpc.net/problem/11403
 * @github https://github.com/chucky6413
 * @author chucky3
 */

import java.util.*;
import java.io.*;

public class Problem11403dfs {
    static int n;
    static int arr[][]; //���� ���
    static int path[][]; //���
    static boolean visit[]; //�湮

    public static void main(String arg[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String temp[];

        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1][n + 1]; //���� ���
        path = new int[n + 1][n + 1]; //���
        visit = new boolean[n + 1];

        for (int i = 1; i <= n; i++) { //�Է� �ޱ�
            temp = br.readLine().split(" ");
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(temp[j - 1]);
            }
        }

        for (int i = 1; i <= n; i++) { //���� �켱 Ž�� ( depth first search )
            Arrays.fill(visit, false);
            dfs(i, i);
        }

        for (int i = 1; i <= n; i++) { //��¹� �����
            for (int j = 1; j <= n; j++) {
                sb.append(path[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb); //���� ���
        //System.out.println(Arrays.deepToString(arr));
        //System.out.println(Arrays.deepToString(path));
    }

    public static void dfs(int start, int v) { //�Ű����� start : ������ , v : ���� Ž�� ��ġ ����
        for (int i = 1; i <= n; i++) {
            if (arr[v][i] == 1 && !visit[i]) { //���� Ž������ ������ i�� �����ϰ�, �湮���� �ʾҴٸ�
                path[start][i] = 1; //��� 1
                visit[i] = true; //�湮 true
                dfs(start, i); //Ž��
            }
        }
    }
}