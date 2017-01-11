/*
 * 2016.12.29
 * ÀÌºÐ ±×·¡ÇÁ
 *
 * @problem https://www.acmicpc.net/problem/1707
 * @author chucky3
 */
import java.util.*;

public class Main {
	static List<Integer>[] adj;
	static int[] visited; // ¹æ¹® »öÄ¥ 1:»¡°­, 2:ÆÄ¶û
	static int k,v,e;
	static String result;
	public static void main(String arg[]){
		Scanner input = new Scanner(System.in);
		k = input.nextInt();
		for(int i=0;i<k;i++){
			result="YES";
			v = input.nextInt();
			e = input.nextInt();
			
			adj = new ArrayList[v+1];
			for(int j=1;j<=v;j++)
				adj[j] = new ArrayList<Integer>();
			visited = new int[v+1];
			
			for(int j=0;j<e;j++){
				int a = input.nextInt();
				int b = input.nextInt();
				
				adj[a].add(b);
				adj[b].add(a);
			}
			for(int j=1;j<=v;j++){
				if(visited[j]==0)
					dfs(j,1);
			}
			System.out.println(result);
		}
	}
	public static void dfs(int s,int color){
		visited[s]=color;
		for(int vertex : adj[s]){
			if(visited[vertex]==0){
				dfs(vertex,color==1?2:1);
			}else if(visited[vertex]==visited[s]){
				result="NO";
				return;
			}
		}
	}
}