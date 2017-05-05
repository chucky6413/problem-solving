/*
 * 2017.05.05
 * 프림 알고리즘
 * 
 * @problem https://www.acmicpc.net/problem/1197
 * @github https://github.com/chucky6413
 * @author chucky3
 */

import java.io.*;
import java.util.*;

public class Main {
	static int v,e;
	static boolean visit[];
	static List<Edge> list[];
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp[];
		
		temp = br.readLine().split(" ");
		v = Integer.parseInt(temp[0]);
		e = Integer.parseInt(temp[1]);
		
		visit = new boolean[v];
		list = new LinkedList[v];
		
		for(int i=0;i<v;i++){
			list[i] = new LinkedList<Edge>();
		}
		
		for(int i=0;i<e;i++){
			temp = br.readLine().split(" ");
			int start = Integer.parseInt(temp[0])-1;
			int end = Integer.parseInt(temp[1])-1;
			int weight = Integer.parseInt(temp[2]);
			list[start].add(new Edge(end,weight));
			list[end].add(new Edge(start,weight));
		}
		br.close();
				
		int ans = 0;
		int count = 0;
		int node = 0;
		PriorityQueue<Edge> queue = new PriorityQueue<Edge>();
		visit[node] = true;
		while(count<v-1){
			for(int i=0;i<list[node].size();i++){
				queue.offer(list[node].get(i));
			}
			
			while(!queue.isEmpty()){
				Edge e = queue.poll();
				if(!visit[e.end]){
					visit[e.end] = true;
					ans+=e.weight;
					node = e.end;
					count++;
					break;
				}
			}
		}
		System.out.println(ans);
	}
}
class Edge implements Comparable<Edge>{
	int end;
	int weight;
	
	public Edge(int end,int weight){
		this.end = end;
		this.weight = weight;
	}
	
	public int compareTo(Edge e){
		return weight<e.weight?-1:1;
	}
}
