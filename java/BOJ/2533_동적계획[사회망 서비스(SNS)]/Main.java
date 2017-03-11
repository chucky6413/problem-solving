/*
 * 2017.01.23
 * 동적계획
 *
 * @problem https://www.acmicpc.net/problem/2533
 * @github https://github.com/chucky6413/Algorithm-study/tree/master/java/BOJ
 * @author chucky3
 */
import java.util.*;
import java.io.*;
public class Main {
	static List<Integer> list[];
	static boolean visited[];
	static int dp[][];
	public static void main(String arg[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		list = new LinkedList[n+1];
		visited = new boolean[n+1];
		dp = new int[n+1][2];
		
		for(int i=1;i<=n;i++){
			list[i] = new LinkedList<Integer>();
		}
		
		String temp[];
		for(int i=1;i<n;i++){
			temp = br.readLine().split(" ");
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);
			list[a].add(b);
			list[b].add(a);
		}
		solve(1); //dp 값 계산
		System.out.println(Math.min(dp[1][0],dp[1][1])); //최소값 출력
	}
	public static void solve(int n){
		dp[n][1] = 1; //adapter가 1일 때,
		visited[n] = true;
		
		for(int i=0;i<list[n].size();i++){
			int child = list[n].get(i);
			if(!visited[child]){
				solve(child);
				dp[n][0] += dp[child][1]; //adpater가 0일 때는, child의 adapter는 1만 가능하다.
				dp[n][1] += Math.min(dp[child][0],dp[child][1]); //adapter가 1일 때는 둘 다 가능하다.
			}
		}
	}
}