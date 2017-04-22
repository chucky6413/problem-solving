/*
 * 2017.04.22
 * µ¿Àû°èÈ¹
 * 
 * @problem https://www.acmicpc.net/problem/1932
 * @github https://github.com/chucky6413
 * @author chucky3
 */

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	static int n;
	static int arr[][];
	static int dp[][];
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp[];
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		dp = new int[n][n];
		
		for(int i=0;i<n;i++){
			temp = br.readLine().split(" ");
			for(int j=0;j<=i;j++){
				arr[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		dp[0][0] = arr[0][0];
		for(int i=0;i<n-1;i++){
			for(int j=0;j<=i;j++){
				dp[i+1][j] = Math.max(dp[i][j]+arr[i+1][j],dp[i+1][j]);
				dp[i+1][j+1] = Math.max(dp[i][j]+arr[i+1][j+1],dp[i+1][j+1]);
			}
		}
		
		int max = 0;
		for(int i=0;i<n;i++){
			if(max<dp[n-1][i]){
				max = dp[n-1][i];
			}
		}
		System.out.println(max);
	}
}
