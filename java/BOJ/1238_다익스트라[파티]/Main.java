/*
 * 2017.01.18
 * 다익스트라 알고리즘
 *
 * @problem https://www.acmicpc.net/problem/1238
 * @github https://github.com/chucky6413/Algorithm-study/tree/master/java/BOJ
 * @author chucky3
 */
import java.io.*;
import java.util.*;

public class Main {
	static List<Node> adj[]; //인접 리스트
	static int dist[][]; //각 마을에서 파티장까지 가는 길
	static int reDist[]; // 돌아가는 길
	static int max = 0;
	public static void main(String arg[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n,m,x;
		String temp[] = br.readLine().split(" ");
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);
		x = Integer.parseInt(temp[2]);
		
		adj = new LinkedList[n+1];
		dist = new int[n+1][n+1];
		reDist = new int[n+1];
		for(int i=1;i<=n;i++){
			adj[i] = new LinkedList<Node>();
		}
		//인접 연결
		for(int i=1;i<=m;i++){
			int a,b,c;
			temp = br.readLine().split(" ");
			a = Integer.parseInt(temp[0]);
			b = Integer.parseInt(temp[1]);
			c = Integer.parseInt(temp[2]);
			
			adj[a].add(new Node(b,c));
		}
		
		PriorityQueue<Node> queue = new PriorityQueue<Node>(); 
		
		//돌아가는 길 거리 구하기
		Arrays.fill(reDist, 1000001);
		reDist[x] = 0; //돌아가는 길 시작점
		queue.offer(new Node(x,reDist[x]));
		while(!queue.isEmpty()){
			int K = queue.peek().index;
			queue.poll();
			
			for(int i=0;i<adj[K].size();i++){
				int index = adj[K].get(i).index;
				if(reDist[index]>reDist[K]+adj[K].get(i).distance){
					reDist[index] = reDist[K]+adj[K].get(i).distance;
					queue.offer(new Node(index,reDist[index]));
				}
			}
		}
		
		//마을에서 파티장소까지 가는 거리
		for(int v=1;v<=n;v++){
			if(v==x) //파티장소 거주 인원은 최소값이므로 건너 뛴다.
				continue;
			
			Arrays.fill(dist[v], 1000001);
			dist[v][v] = 0; //돌아가는 길 시작점
			queue.clear();
			queue.offer(new Node(v,dist[v][v]));
			while(!queue.isEmpty()){
				int K = queue.peek().index;
				queue.poll();
				
				for(int i=0;i<adj[K].size();i++){
					int index = adj[K].get(i).index;
					if(dist[v][index]>dist[v][K]+adj[K].get(i).distance){
						dist[v][index] = dist[v][K]+adj[K].get(i).distance;
						queue.offer(new Node(index,dist[v][index]));
					}
				}
			}
			//최대 값 검사
			if(dist[v][x]+reDist[v]>max){
				max = dist[v][x]+reDist[v];
			}
			
		}
		System.out.println(max); //최대 값 출력
	}
}
class Node implements Comparable<Node>{
	int index;
	int distance;
	
	public Node(int index,int distance){
		this.index = index;
		this.distance = distance;
	}
	public int compareTo(Node n){
		return distance-n.distance;
	}
}