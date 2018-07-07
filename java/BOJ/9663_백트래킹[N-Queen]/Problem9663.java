/*
 * 2017.03.25
 * ��Ʈ��ŷ
 *
 * @problem https://www.acmicpc.net/problem/9663
 * @github https://github.com/chucky6413
 * @author chucky3
 */

import java.util.*;

public class Problem9663 {
    static int N, count = 0;
    static int visit[]; // 1 2 3 4 5 6 7 8

    public static void main(String arg[]) {
        Scanner input = new Scanner(System.in);
        N = input.nextInt();
        visit = new int[N + 1];

        solve(0);

        System.out.println(count);
    }

    public static void solve(int index) {
        if (index == N) {
            count++;
            return;
        }
        for (int i = 1; i <= N; i++) {
            visit[index + 1] = i; //i = �� , index = ��
            if (isEmpty(index + 1)) {
                solve(index + 1);
            }
        }
    }

    public static boolean isEmpty(int cur) {
        for (int i = 1; i < cur; i++) {//���� ���� �ִ��� , �밢���� ���� �ִ���
            if (visit[i] == visit[cur] || cur - i == Math.abs(visit[cur] - visit[i])) {
                return false;
            }
        }
        return true; //cur�� 1�϶�, �տ� �ƹ� �͵� �����Ƿ� true
    }
}