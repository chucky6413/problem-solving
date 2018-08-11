/*
 * 2017.01.12
 * ���� ����
 * 
 * @problem https://www.acmicpc.net/problem/1838
 * @github https://github.com/chucky6413
 * @author chucky3
 */

import java.util.*;
import java.io.*;

public class Problem1838 {
    public static void main(String arg[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Node> queue = new PriorityQueue<Node>();
        int n = Integer.parseInt(br.readLine());

        String st[] = br.readLine().split(" ");
        int arr[] = new int[n];
        int result = -1;

        for (int i = 0; i < n; i++) {
            Node node = new Node(Integer.parseInt(st[i]), i);
            queue.add(node);
        }

        int currentIndex = 0;
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            result = Math.max(result, temp.index - currentIndex);
            currentIndex++;
        }

        System.out.println(result);
    }

    static class Node implements Comparable<Node> {
        int value;
        int index;

        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }

        public int compareTo(Node n) {
            return value - n.value;
        }
    }
}
