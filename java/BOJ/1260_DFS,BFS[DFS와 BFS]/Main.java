/*
 * 2016.12.28
 * DFS,BFS
 *
 * @problem https://www.acmicpc.net/problem/1260
 * @github https://github.com/chucky6413/Algorithm-study/tree/master/java/BOJ
 * @author chucky3
 */
import java.util.*;

public class Main {
	static int[][] adj;
	static int[] visited;
	static int n,m,start;
	static StringBuilder sb = new StringBuilder();
	public static void main(String arg[]){
		Scanner input = new Scanner(System.in);
		
		n=input.nextInt();
		m=input.nextInt();
		start=input.nextInt();
		
		adj = new int[n+1][n+1];
		for(int i=0;i<m;i++){
			int a=input.nextInt();
			int b=input.nextInt();
			
			adj[a][b] = adj[b][a] = 1;
		}
		
		visited=new int[n+1];
		dfs(start);
		sb.append("\n");
		visited=new int[n+1];
		bfs(start);
		
		System.out.println(sb.toString());
	}
	public static void dfs(int s){
		sb.append(s+" ");
		visited[s]=1;
		
		for(int i=1;i<=n;i++){
			if(visited[i]==0 && adj[s][i]==1){
				dfs(i);
			}
		}
	}
	public static void bfs(int s){
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(s);
		
		while(!queue.isEmpty()){
			s = queue.poll();
			sb.append(s+" ");
			visited[s]=1;
			
			for(int i=1;i<=n;i++){
				if(visited[i]==0 && adj[s][i]==1){
					visited[i]=1;
					queue.offer(i);
				}
			}
		}
	}
}