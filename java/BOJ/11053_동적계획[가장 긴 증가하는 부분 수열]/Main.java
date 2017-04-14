/*
 * 2017.04.15
 * 동적계획
 * 
 * @problem https://www.acmicpc.net/problem/11053
 * @github https://github.com/chucky6413
 * @author chucky3
 */
import java.util.*;
import java.io.*;

public class Main{
	static int n,ans=0;
	static int a[];
	static int dp[]; //앞에서부터 lis
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
		
		for(int i=0;i<n;i++){ //앞에서 부터
			dp[i] = 1;
			for(int j=0;j<i;j++){
				if(a[i]>a[j] && dp[j]+1>dp[i]){
					dp[i] = dp[j] + 1;
				}
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