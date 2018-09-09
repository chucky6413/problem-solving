/*
 * 2017.05.19
 * ��Ʈ��ũ �÷ο� , ������ ī�� �˰���
 * 
 * @problem https://www.acmicpc.net/problem/6086
 * @github https://github.com/chucky6413
 * @author chucky3
 */

import java.util.*;
import java.io.*;

public class Problem6086 {
    static int n;
    static List<Integer> adj[] = new LinkedList[52];
    static int capacity[][] = new int[52][52];
    static int flow[][] = new int[52][52];

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp[];

        temp = br.readLine().split(" ");
        n = Integer.parseInt(temp[0]);

        for (int i = 0; i < 52; i++) {
            adj[i] = new LinkedList<Integer>();
        }

        for (int i = 0; i < n; i++) {
            temp = br.readLine().split(" ");
            int start = trans(temp[0].charAt(0));
            int end = trans(temp[1].charAt(0));
            int capa = Integer.parseInt(temp[2]);
            adj[start].add(end);
            adj[end].add(start);
            capacity[start][end] += capa;
        }

        int result = 0, S = trans('A'), E = trans('Z');

        while (true) {
            int prev[] = new int[52];
            Arrays.fill(prev, -1);
            Queue<Integer> queue = new LinkedList<Integer>();
            queue.offer(S);
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (int i = 0; i < adj[cur].size(); i++) {
                    int next = adj[cur].get(i);
                    if (capacity[cur][next] - flow[cur][next] > 0 && prev[next] == -1) {
                        queue.offer(next);
                        prev[next] = cur;
                        if (next == E) break;
                    }
                }
            }
            if (prev[E] == -1) break;
            int minFlow = Integer.MAX_VALUE;
            for (int i = E; i != S; i = prev[i]) {
                minFlow = Math.min(minFlow, capacity[prev[i]][i] - flow[prev[i]][i]);
            }
            for (int i = E; i != S; i = prev[i]) {
                flow[prev[i]][i] += minFlow;
                flow[i][prev[i]] -= minFlow;
            }
            result += minFlow;
        }

        System.out.println(result);
    }

    public static int trans(char c) {
        if (c <= 'Z') return (int) c - 65;
        return (int) c - 71;
    }
}