/*
 * 2017.03.27
 * DFS N�� 10�̹Ƿ�, 10! -> 360�� .. ���� �������ڴ�.
 * �� �ڵ�� N! ȿ�������� ����.
 *
 * @problem https://www.acmicpc.net/problem/10971
 * @github https://github.com/chucky6413
 * @author chucky3
 */

import java.util.*;

public class Problem10971 {
    static int n, min = 10000001;
    static boolean visit[] = new boolean[11];
    static int w[][] = new int[11][11];

    public static void main(String arg[]) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                w[i][j] = input.nextInt();
            }
        }

        for (int i = 1; i <= n; i++) {
            solve(i, i, 1, 0);
        }

        System.out.println(min);
    }

    public static void solve(int start, int cur, int depth, int cost) { //dfs �̿��Ͽ� ó��.
        if (depth == n) {
            if (w[cur][start] == 0) { //���������� ���ư� �� �������� ����ó��
                return;
            }

            cost += w[cur][start];
            if (cost < min) {
                min = cost;
            }
            return;
        }

        visit[cur] = true;

        for (int i = 1; i <= n; i++) {
            if (!visit[i] && w[cur][i] != 0) {
                solve(start, i, depth + 1, cost + w[cur][i]);
            }
        }

        visit[cur] = false;
    }
}