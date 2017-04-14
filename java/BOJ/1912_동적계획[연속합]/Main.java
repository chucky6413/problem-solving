/*
 * 2017.04.15
 * 동적계획
 * 
 * @problem https://www.acmicpc.net/problem/1912
 * @github https://github.com/chucky6413
 * @author chucky3
 */
import java.util.*;
import java.io.*;

public class Main{
	static int n,ans=Integer.MIN_VALUE;
	static int a[];
	static int dp[];
	public static void main(String arg[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp[];
		
		n = Integer.parseInt(br.readLine());
		a = new int[n];
		dp = new int[n];
		
		temp = br.readLine().split(" ");
		for(int i=0;i<n;i++){
			a[i] = Integer.parseInt(temp[i]);
		}
		
		dp[0] = a[0];
		for(int i=1;i<n;i++){ //앞에서 부터
			dp[i] = a[i];
			if(dp[i-1]+dp[i]>dp[i]){
				dp[i] = dp[i-1] + dp[i];
			}
			
		}
		for(int i=0;i<n;i++){
			if(dp[i]>ans){
				ans = dp[i];
			}
		}
		System.out.println(ans);
	}
}