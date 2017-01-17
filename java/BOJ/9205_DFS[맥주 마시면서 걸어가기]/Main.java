/*
 * 2017.01.18
 * DFS
 *
 * @problem https://www.acmicpc.net/problem/9205
 * @author chucky3
 */
import java.util.Scanner;
import java.util.*;

public class Main {
	static List<Integer> list[]; //인접 리스트
	static int dist[][],visited[];
	static String result;
	public static void main(String arg[]){
		Scanner input = new Scanner(System.in);
		int t = input.nextInt(); //test case
		
		for(int i=0;i<t;i++){
			result = "sad";
			
			int n = input.nextInt()+2;
			list = new LinkedList[n+1];
			dist = new int[n+1][2];
			visited = new int[n+1];
			for(int j=1;j<=n;j++){
				list[j] = new LinkedList<Integer>();
				dist[j][0] = input.nextInt(); //x좌표
				dist[j][1] = input.nextInt(); //y좌표
			}
			//인접 확인
			for(int a=1;a<=n;a++){
				for(int b=1;b<=n;b++){
					if(a==b) continue;
					int dis = Math.abs(dist[a][0]-dist[b][0]) + Math.abs(dist[a][1]-dist[b][1]);
					if(dis<=1000)
						list[a].add(b);
				}
			}
			dfs(1,n);
			System.out.println(result);
		}

	}
	public static void dfs(int v,int n){
		if(v==n){
			result="happy";
			return;
		}
		for(int i=0;i<list[v].size();i++){
			int v2 = list[v].get(i);
			if(visited[v2]==0){
				visited[v2]=1;
				dfs(v2,n);
			}
		}
	}
}