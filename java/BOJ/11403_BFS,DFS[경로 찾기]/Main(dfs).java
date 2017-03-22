/*
 * 2017.03.10
 * DFS로 풀이
 *
 * @problem https://www.acmicpc.net/problem/11403
 * @github https://github.com/chucky6413
 * @author chucky3
 */
import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int arr[][]; //인접 행렬
	static int path[][]; //경로
	static boolean visit[]; //방문
	public static void main(String arg[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String temp[];
				
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1][n+1]; //인접 행렬
		path = new int[n+1][n+1]; //경로
		visit = new boolean[n+1]; 
		
		for(int i=1;i<=n;i++){ //입력 받기
			temp = br.readLine().split(" ");
			for(int j=1;j<=n;j++){
				arr[i][j] = Integer.parseInt(temp[j-1]);
			}
		}
		
		for(int i=1;i<=n;i++){ //깊이 우선 탐색 ( depth first search )
			Arrays.fill(visit, false);
			dfs(i,i);
		}
		
		for(int i=1;i<=n;i++){ //출력문 만들기
			for(int j=1;j<=n;j++){
				sb.append(path[i][j]+" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb); //정답 출력
		//System.out.println(Arrays.deepToString(arr));
		//System.out.println(Arrays.deepToString(path));
	}
	public static void dfs(int start,int v){ //매개변수 start : 시작점 , v : 현재 탐색 위치 정점
		for(int i=1;i<=n;i++){
			if(arr[v][i]==1 && !visit[i]){ //현재 탐색중인 정점과 i가 인접하고, 방문되지 않았다면
				path[start][i]=1; //경로 1
				visit[i] = true; //방문 true
				dfs(start,i); //탐색
			}
		}
	}
}