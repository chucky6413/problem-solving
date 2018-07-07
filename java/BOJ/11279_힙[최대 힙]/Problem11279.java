/*
 * 2017.03.31
 * �ִ� ��
 * 
 * @problem https://www.acmicpc.net/problem/11279
 * @github https://github.com/chucky6413
 * @author chucky3
 */

import java.util.*;
import java.io.*;

public class Problem11279 {
    static int n;
    static final String NEWLINE = "\n";

    public static void main(String arg[]) throws IOException {
        Scanner input = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        n = input.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(1, Collections.reverseOrder()); //reverse�� ����
        for (int i = 0; i < n; i++) {
            int num = input.nextInt();
            if (num == 0) {
                if (queue.isEmpty()) sb.append("0" + NEWLINE);
                else sb.append(queue.poll() + NEWLINE);
            } else {
                queue.offer(num);
            }
        }
        System.out.println(sb);
    }
}