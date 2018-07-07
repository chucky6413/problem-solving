/*
 * 2017.03.26
 * ����
 *
 * @problem https://www.acmicpc.net/problem/1181
 * @github https://github.com/chucky6413
 * @author chucky3
 */

import java.util.*;

public class Problem1181 {
    static int n;
    static PriorityQueue<String> queue[] = new PriorityQueue[51]; //���ڿ� ���̿� ���� �迭 ����Ʈ

    public static void main(String arg[]) {
        Scanner input = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        n = input.nextInt();
        for (int i = 0; i < n; i++) {
            String s = input.next();
            if (queue[s.length()] == null) {
                queue[s.length()] = new PriorityQueue<String>();
            }
            queue[s.length()].add(s);
        }

        for (int i = 1; i < 51; i++) {
            String front = "";
            while (queue[i] != null && !queue[i].isEmpty()) {
                if (!front.equals(queue[i].peek())) {
                    front = queue[i].peek();
                    sb.append(queue[i].poll() + "\n");
                } else {
                    queue[i].poll();
                }
            }
        }
        System.out.print(sb);
    }
}