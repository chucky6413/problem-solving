/*
 * 2017.01.23
 * 동적계획
 *
 * @problem https://www.acmicpc.net/problem/10942
 * @github https://github.com/chucky6413/Algorithm-study/tree/master/java/BOJ
 * @author chucky3
 */
import java.util.Arrays;
import java.io.*;
public class Main {
	static int arr[],dp[][];
	public static void main(String arg[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		String temp[];
		
		int n = Integer.parseInt(br.readLine());
		arr = new int[n+1];
		dp = new int[n+1][n+1];
		temp = br.readLine().split(" ");
		for(int i=1;i<=n;i++) arr[i] = Integer.parseInt(temp[i-1]);
		for(int i=1;i<=n;i++) Arrays.fill(dp[i], -1);
		
		int m = Integer.parseInt(br.readLine());
		for(int i=0;i<m;i++){
			temp = br.readLine().split(" ");
			int s = Integer.parseInt(temp[0]);
			int e = Integer.parseInt(temp[1]);
			int result = solve(s,e);
			sb.append(result+"\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	public static int solve(int front,int back){
		if(front>=back) return 1;
		if(dp[front][back]==-1){
			dp[front][back] = 0;
			if(arr[front]==arr[back]){
				if(solve(front+1,back-1)==1){ //팰린드롬의, 내부도 팰린드롬 조건이 맞을 때
					dp[front][back] = 1; //팰린드롬이다.
				}
			}
		}
		return dp[front][back];
	}
}