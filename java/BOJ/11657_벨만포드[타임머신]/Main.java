/*
 * 2017.05.12
 * 벨만포드
 * 
 * @problem https://www.acmicpc.net/problem/11657
 * @github https://github.com/chucky6413
 * @author chucky3
 */

import java.io.*;
import java.util.*;

public class Main {
	static final int INF = 60000001;
	static int n,m;
	static List<Edge> adj[];
	static int dist[];
	static boolean cycle;
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp[];
		
		temp = br.readLine().split(" ");
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);
		
		adj = new LinkedList[n+1];
		dist = new int[n+1];
		
		for(int i=1;i<=n;i++){
			adj[i] = new LinkedList<Edge>();
		}
		for(int i=0;i<m;i++){
			temp = br.readLine().split(" ");
			int start = Integer.parseInt(temp[0]);
			int end = Integer.parseInt(temp[1]);
			int weight = Integer.parseInt(temp[2]);
			adj[start].add(new Edge(end,weight));
		}
		br.close();
		
		Arrays.fill(dist,INF);
		dist[1] = 0;
		for(int i=1;i<=n;i++){
			for(int j=1;j<=n;j++){
				for(int k=0;k<adj[j].size();k++){
					Edge e = adj[j].get(k);
					if(e.weight==INF || dist[e.end]>dist[j]+e.weight){
						dist[e.end] = dist[j]+e.weight;
						if(i==n) cycle = true;
					}
				}
			}
		}
		
		if(cycle) System.out.println(-1);
		else{
			for(int i=2;i<=n;i++){
				if(dist[i]!=INF)
					System.out.println(dist[i]);
				else
					System.out.println(-1);
			}
		}
	}
}
class Edge{
	int end;
	int weight;
	public Edge(int end,int weight){
		this.end = end;
		this.weight = weight;
	}
}