/*
 * 2017.04.15
 * 동적계획
 * 
 * @problem https://www.acmicpc.net/problem/11054
 * @github https://github.com/chucky6413
 * @author chucky3
 */
import java.util.*;
import java.io.*;

public class Main{
	static int n,ans=0;
	static int a[];
	static int front[]; //앞에서부터 lis
	static int back[]; //뒤에서부터 lis
	static int dp[];
	public static void main(String arg[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp[];
		
		n = Integer.parseInt(br.readLine());
		a = new int[n];
		front = new int[n];
		back = new int[n];
		dp = new int[n];
		
		temp = br.readLine().split(" ");
		for(int i=0;i<n;i++){
			a[i] = Integer.parseInt(temp[i]);
		}
		
		for(int i=0;i<n;i++){ //앞에서 부터
			front[i] = 1;
			for(int j=0;j<i;j++){
				if(a[i]>a[j] && front[j]+1>front[i]){
					front[i] = front[j] + 1;
				}
			}
		}
		
		for(int i=n-1;i>=0;i--){ //뒤에서 부터
			back[i] = 1;
			for(int j=n-1;j>=i;j--){
				if(a[i]>a[j] && back[j]+1>back[i]){
					back[i] = back[j] + 1;
				}
			}
			dp[i] = front[i] + back[i]; // 두개 더해주기
		}
		
		for(int i=0;i<n;i++){
			if(dp[i]>ans){
				ans = dp[i];
			}
		}
		
		System.out.println(ans-1); //겹치는 부분 -1 해주기.
	}
}