/*
 * 2017.03.18
 * BFS
 *
 * @problem https://www.acmicpc.net/problem/9019
 * @github https://github.com/chucky6413
 * @author chucky3
 */

import java.util.*;

public class Problem9019 {
    static int n, resultA, resultB;
    static String how[] = new String[10000];
    static boolean visit[] = new boolean[10000];

    public static void main(String arg[]) {
        Scanner input = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        n = input.nextInt();

        Queue<Integer> queue = new LinkedList<Integer>();


        for (int i = 0; i < n; i++) {
            queue.clear();
            Arrays.fill(how, "");
            Arrays.fill(visit, false);
            resultA = input.nextInt();
            resultB = input.nextInt();
            queue.add(resultA); //������ ���
            visit[resultA] = true;

            while (!queue.isEmpty()) {
                int v = queue.poll();

                int next = (v * 2) % 10000;
                if (visit[next] == false) {
                    visit[next] = true;
                    how[next] = how[v] + "D";
                    queue.add(next);
                }

                next = v - 1;
                if (next == -1) next = 9999;
                if (visit[next] == false) {
                    visit[next] = true;
                    how[next] = how[v] + "S";
                    queue.add(next);
                }

                next = (v * 10) % 10000 + (v / 1000);
                if (visit[next] == false) {
                    visit[next] = true;
                    how[next] = how[v] + "L";
                    queue.add(next);
                }

                next = (v % 10) * 1000 + (v / 10);
                if (visit[next] == false) {
                    visit[next] = true;
                    how[next] = how[v] + "R";
                    queue.add(next);
                }

            }
            sb.append(how[resultB] + "\n");
        }
        System.out.println(sb);
    }
}