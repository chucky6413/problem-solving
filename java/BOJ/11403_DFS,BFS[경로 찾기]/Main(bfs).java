/*
 * 2017.03.10
 * BFS로 풀이
 *
 * @problem https://www.acmicpc.net/problem/11403
 * @github https://github.com/chucky6413/Algorithm-study/tree/master/java/BOJ
 * @author chucky3
 */
import java.util.*;
import java.io.*;

public class Main2 {
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
		
		for(int i=1;i<=n;i++){ //너비 우선 탐색 ( breadth first search )
			Arrays.fill(visit, false);
			bfs(i);
		}
		
		for(int i=1;i<=n;i++){ //출력문 만들기
			for(int j=1;j<=n;j++){
				sb.append(path[i][j]+" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb); //정답 출력
	}
	public static void bfs(int start){ //start : 경로를 찾는 시작 정점
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start); //시작점 add
		
		while(!queue.isEmpty()){
			int v = queue.poll(); //v : 큐의 맨앞에서 뽑은 정점
			
			for(int i=1;i<=n;i++){
				if(arr[v][i]==1 && !visit[i]){
					path[start][i] = 1;
					visit[i] = true;
					queue.add(i);
				}
			}
		}		
	}
}