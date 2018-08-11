/*
 * 2017.03.16
 * BFS ( ����ġ�� 1�̹Ƿ� )
 *
 * @problem https://www.acmicpc.net/problem/13913
 * @github https://github.com/chucky6413
 * @author chucky3
 */

import java.util.*;

public class Problem13913 {
    static int n, k, time[], from[];
    static boolean visit[];
    static int MAX = 100000;

    public static void main(String arg[]) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        k = input.nextInt();
        time = new int[MAX + 1]; //�ð�
        visit = new boolean[MAX + 1]; //�湮
        from = new int[MAX + 1]; //��� �Դ���

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(n);
        visit[n] = true;

        while (!queue.isEmpty()) {
            int d = queue.poll();

            if (d - 1 >= 0) {
                if (visit[d - 1] == false) {
                    queue.add(d - 1);
                    visit[d - 1] = true; //�湮 Ȯ��
                    time[d - 1] = time[d] + 1; //�ð� �߰�
                    from[d - 1] = d; //��� �Դ���
                }
            }

            if (d + 1 <= MAX) {
                if (visit[d + 1] == false) {
                    queue.add(d + 1);
                    visit[d + 1] = true;
                    time[d + 1] = time[d] + 1;
                    from[d + 1] = d;
                }
            }

            if (d * 2 <= MAX) {
                if (visit[d * 2] == false) {
                    queue.add(d * 2);
                    visit[d * 2] = true;
                    time[d * 2] = time[d] + 1;
                    from[d * 2] = d;
                }
            }
        }

        System.out.println(time[k]);
        printFrom(n, k);
    }

    public static void printFrom(int n, int k) { //������ , ������
        if (n != k) {
            printFrom(n, from[k]); //�������� ��� �Դ���.
        }
        System.out.print(k + " ");
    }
}