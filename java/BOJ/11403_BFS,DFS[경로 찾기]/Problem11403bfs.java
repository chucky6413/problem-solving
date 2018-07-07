/*
 * 2017.03.10
 * BFS�� Ǯ��
 *
 * @problem https://www.acmicpc.net/problem/11403
 * @github https://github.com/chucky6413
 * @author chucky3
 */

import java.util.*;
import java.io.*;

public class Problem11403bfs {
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

        for (int i = 1; i <= n; i++) { //�ʺ� �켱 Ž�� ( breadth first search )
            Arrays.fill(visit, false);
            bfs(i);
        }

        for (int i = 1; i <= n; i++) { //��¹� �����
            for (int j = 1; j <= n; j++) {
                sb.append(path[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb); //���� ���
    }

    public static void bfs(int start) { //start : ��θ� ã�� ���� ����
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(start); //������ add

        while (!queue.isEmpty()) {
            int v = queue.poll(); //v : ť�� �Ǿտ��� ���� ����

            for (int i = 1; i <= n; i++) {
                if (arr[v][i] == 1 && !visit[i]) {
                    path[start][i] = 1;
                    visit[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}