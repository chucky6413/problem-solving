/*
 * 2016.11.26
 * 다익스트라 알고리즘(우선순위 큐) nlogn
 * 
 * @problem https://www.acmicpc.net/problem/1753
 * @author chucky3
 */
import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;

public class Main {
	static int V,E,K,u,v,w,INF=3000001;
	static List<Node>[] adj;
	static int[] dist;
	
	public static void main(String arg[]){
		Scanner sc = new Scanner(System.in);
		V=sc.nextInt();
		E=sc.nextInt();
		K=sc.nextInt();
		
		adj=new ArrayList[V+1];
		dist=new int[V+1];
		
		for(int i=1;i<=V;i++){
			adj[i]=new ArrayList<Node>();
		}
		
		
		for(int i=0;i<E;i++){ //인접 리스트,가중치
			u=sc.nextInt();
			v=sc.nextInt();
			w=sc.nextInt();
			
			adj[u].add(new Node(v,w));
		}
		
		for(int i=1;i<=V;i++){ //dist 초기화
			dist[i]=INF;
		}
		
		PriorityQueue<Node> q = new PriorityQueue<Node>(); //우선순위 큐
		dist[K]=0; //시작점
		q.offer(new Node(K,dist[K])); //q insert
		
		while(!q.isEmpty()){
			K=q.peek().index;
			q.poll();
			
			for(int j=0;j<adj[K].size();j++){
				int index = adj[K].get(j).index;
				if(dist[index]>dist[K]+adj[K].get(j).distance){
					dist[index]=dist[K]+adj[K].get(j).distance;
					q.offer(new Node(index,dist[index]));
				}
			}
		}
		
		for(int i=1;i<=V;i++){//출력
			System.out.println(dist[i]!=INF?dist[i]:"INF");
		}
	}
}
class Node implements Comparable<Node>{
	int index;
	int distance;
	
	public Node(int index,int distance){
		this.index=index;
		this.distance=distance;
	}
	
	public int compareTo(Node n){
		return distance <= n.distance ? -1 : 1;
	}
}