/*
 * 2017.01.18
 * ���ͽ�Ʈ�� �˰���
 *
 * @problem https://www.acmicpc.net/problem/1238
 * @github https://github.com/chucky6413
 * @author chucky3
 */

import java.io.*;
import java.util.*;

public class Problem1238 {
    static List<Node> adj[]; //���� ����Ʈ
    static int dist[][]; //�� �������� ��Ƽ����� ���� ��
    static int reDist[]; // ���ư��� ��
    static int max = 0;

    public static void main(String arg[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, m, x;
        String temp[] = br.readLine().split(" ");
        n = Integer.parseInt(temp[0]);
        m = Integer.parseInt(temp[1]);
        x = Integer.parseInt(temp[2]);

        adj = new LinkedList[n + 1];
        dist = new int[n + 1][n + 1];
        reDist = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new LinkedList<Node>();
        }
        //���� ����
        for (int i = 1; i <= m; i++) {
            int a, b, c;
            temp = br.readLine().split(" ");
            a = Integer.parseInt(temp[0]);
            b = Integer.parseInt(temp[1]);
            c = Integer.parseInt(temp[2]);

            adj[a].add(new Node(b, c));
        }

        PriorityQueue<Node> queue = new PriorityQueue<Node>();

        //���ư��� �� �Ÿ� ���ϱ�
        Arrays.fill(reDist, 1000001);
        reDist[x] = 0; //���ư��� �� ������
        queue.offer(new Node(x, reDist[x]));
        while (!queue.isEmpty()) {
            int K = queue.peek().index;
            queue.poll();

            for (int i = 0; i < adj[K].size(); i++) {
                int index = adj[K].get(i).index;
                if (reDist[index] > reDist[K] + adj[K].get(i).distance) {
                    reDist[index] = reDist[K] + adj[K].get(i).distance;
                    queue.offer(new Node(index, reDist[index]));
                }
            }
        }

        //�������� ��Ƽ��ұ��� ���� �Ÿ�
        for (int v = 1; v <= n; v++) {
            if (v == x) //��Ƽ��� ���� �ο��� �ּҰ��̹Ƿ� �ǳ� �ڴ�.
                continue;

            Arrays.fill(dist[v], 1000001);
            dist[v][v] = 0; //���ư��� �� ������
            queue.clear();
            queue.offer(new Node(v, dist[v][v]));
            while (!queue.isEmpty()) {
                int K = queue.peek().index;
                queue.poll();

                for (int i = 0; i < adj[K].size(); i++) {
                    int index = adj[K].get(i).index;
                    if (dist[v][index] > dist[v][K] + adj[K].get(i).distance) {
                        dist[v][index] = dist[v][K] + adj[K].get(i).distance;
                        queue.offer(new Node(index, dist[v][index]));
                    }
                }
            }
            //�ִ� �� �˻�
            if (dist[v][x] + reDist[v] > max) {
                max = dist[v][x] + reDist[v];
            }

        }
        System.out.println(max); //�ִ� �� ���
    }

    static class Node implements Comparable<Node> {
        int index;
        int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        public int compareTo(Node n) {
            return distance - n.distance;
        }
    }
}
