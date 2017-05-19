/*
 * 2017.05.19
 * 네트워크 플로우
 * 
 * @problem https://www.acmicpc.net/problem/2188
 * @github https://github.com/chucky6413
 * @author chucky3
 */

import java.util.*;
import java.io.*;

public class Main {
	static final int MAX_N = 200;
	static final int MAX_V = MAX_N*2+2;
	static final int S = MAX_V-2;
	static final int E = MAX_V-1;
	
	static int n,m;
	static List<Integer> adj[] = new LinkedList[MAX_V];
	static int capacity[][] = new int[MAX_V][MAX_V];
	static int flow[][] = new int[MAX_V][MAX_V];
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp[];
		
		temp = br.readLine().split(" ");
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);

		for(int i=0;i<MAX_V;i++){
			adj[i] = new LinkedList<Integer>();
		}
		
		for(int i=0;i<n;i++){
			temp = br.readLine().split(" ");
			for(int j=1;j<temp.length;j++){
				int u = Integer.parseInt(temp[j]) + MAX_N - 1;
				capacity[i][u] = 1;
				adj[i].add(u);
				adj[u].add(i);
			}
			capacity[S][i] = 1; //시작점
			adj[S].add(i);
			adj[i].add(S);
		}
		
		for(int i=MAX_N;i<MAX_N+m;i++){
			capacity[i][E] = 1;
			adj[i].add(E);
			adj[E].add(i);
		}
		
		int total = 0;
		
		while(true){
			int prev[] = new int[MAX_V];
			Arrays.fill(prev,-1);
			Queue<Integer> queue = new LinkedList<Integer>();
			queue.offer(S);
			while(!queue.isEmpty()){
				int cur = queue.poll();
				for(int i=0;i<adj[cur].size();i++){
					int next = adj[cur].get(i);
					if(capacity[cur][next]>flow[cur][next] && prev[next]==-1){
						queue.offer(next);
						prev[next] = cur;
						if(next == E) break;
					}
				}
			}
			if(prev[E]==-1) break;
			
			for(int i=E;i!=S;i=prev[i]){
				flow[prev[i]][i]++;
				flow[i][prev[i]]--;
			}
			total++;
		}
		
		System.out.println(total);
	}
}