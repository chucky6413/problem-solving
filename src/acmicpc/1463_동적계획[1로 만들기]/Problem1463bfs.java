/*
 * 2017.03.17
 * BFS
 *
 * @problem https://www.acmicpc.net/problem/1463
 * @github https://github.com/chucky6413
 * @author chucky3
 */

import java.util.*;

public class Problem1463bfs {
    static int n; //�Է� ���� ����
    static int cost[]; //��� �迭
    static boolean visit[]; //�湮 �ߴ���

    public static void main(String arg[]) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        cost = new int[n + 1]; //��� �迭
        visit = new boolean[n + 1]; //�湮�ߴ���

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(n);

        while (!queue.isEmpty()) { //ť�� ������� �ʴٸ�
            int k = queue.poll(); //ť�� �� �� ����

            if (k % 3 == 0 && visit[k / 3] == false) { //k�� 3���� ������ �������ٸ�
                cost[k / 3] = cost[k] + 1;
                visit[k / 3] = true;
                queue.offer(k / 3);
            }

            if (k % 2 == 0 && visit[k / 2] == false) { //k�� 2�� ������ �������ٸ�
                cost[k / 2] = cost[k] + 1;
                visit[k / 2] = true;
                queue.offer(k / 2);
            }

            if (k - 1 > 1 && visit[k - 1] == false) { //k-1�� 1���� ũ�ٸ�
                cost[k - 1] = cost[k] + 1;
                visit[k - 1] = true;
                queue.offer(k - 1);
            }
        }

        System.out.println(cost[1]); //���� ���
    }
}