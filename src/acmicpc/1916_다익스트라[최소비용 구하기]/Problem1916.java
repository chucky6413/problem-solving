/*
 * 2017.03.17
 * ���ͽ�Ʈ�� �˰���
 *
 * @problem https://www.acmicpc.net/problem/1916
 * @github https://github.com/chucky6413
 * @author chucky3
 */

import java.util.*;
import java.io.*;

public class Problem1916 {
    public static int s, d, n, m, INF = 100000001; //���� 1000��, �ִ� ��� 100000
    public static List<Node> city[]; //����
    public static int totalCost[]; //�� ���

    public static void main(String arg[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp[];

        n = Integer.parseInt(br.readLine()); //���� ����
        m = Integer.parseInt(br.readLine()); //���� ����

        city = new LinkedList[n + 1]; //���� �迭 ����
        totalCost = new int[n + 1]; //�� ��� �迭 ����

        for (int i = 1; i <= n; i++) { //���� �迭�� LinkedList ��ü�� ���� ����
            city[i] = new LinkedList<Node>();
        }

        for (int i = 1; i <= n; i++) { //�� ��� �ʱ�ȭ ( ���Ѵ� = �ִ� ���� �� �ִ� ����� �� INF �� ���� )
            totalCost[i] = INF;
        }

        for (int i = 0; i < m; i++) { //�Է� �ޱ� ���� ���� -> ���� ���� , ���� ���
            temp = br.readLine().split(" ");
            int start = Integer.parseInt(temp[0]); //���� ���� ����
            int dest = Integer.parseInt(temp[1]); //���� ���� ����
            int cost = Integer.parseInt(temp[2]); //���� ��� ����

            city[start].add(new Node(dest, cost)); //���� ���÷� ���� ����� ���� ���ÿ� ��� add
        }

        temp = br.readLine().split(" ");
        s = Integer.parseInt(temp[0]); //�츮�� ���� ������
        d = Integer.parseInt(temp[1]); //�츮�� ���� ������

        PriorityQueue<Node> queue = new PriorityQueue<Node>(); //�켱 ���� ť ����
        totalCost[s] = 0; //���������κ��� ���������� �Ÿ��� 0
        queue.offer(new Node(s, 0)); //���� ���� ��带 queue�� offer

        while (!queue.isEmpty()) { //ť�� �� �� ���� �ݺ�
            int v = queue.poll().index; //ť�� ó�� ��带 �̾� ���� ��ȣ ����

            for (int i = 0; i < city[v].size(); i++) { // ������ ���� ���ÿ��� �� �� �ִ� ���� ���õ��� ���� ��ŭ �ݺ�
                int adj = city[v].get(i).index; //������ ���� ���ÿ� ������ ���� ��ȣ ����

                if (totalCost[adj] > totalCost[v] + city[v].get(i).cost) { //��� ��
                    totalCost[adj] = totalCost[v] + city[v].get(i).cost; //�ּ� ����̸� ����
                    queue.offer(new Node(adj, totalCost[adj])); //ť�� add
                }
            }
        }
        System.out.println(totalCost[d]); //���� �� ���.
    }

    static class Node implements Comparable<Node> {
        int index;
        int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        public int compareTo(Node n) {
            return cost < n.cost ? -1 : 1;
        }
    }
}
