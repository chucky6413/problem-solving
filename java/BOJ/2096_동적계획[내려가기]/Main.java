/*
 * 2017.04.26
 * µ¿Àû°èÈ¹
 * 
 * @problem https://www.acmicpc.net/problem/2096
 * @github https://github.com/chucky6413
 * @author chucky3
 */

import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int arr[][];
	static int dp[][];
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp[];
		n = Integer.parseInt(br.readLine());
		arr = new int[n][3];
		dp = new int[n][3];
		
		for(int i=0;i<n;i++){
			temp = br.readLine().split(" ");
			for(int j=0;j<3;j++){
				arr[i][j] = Integer.parseInt(temp[j]);
			}
		}
		br.close();
		
		dp[0][0] = arr[0][0];
		dp[0][1] = arr[0][1];
		dp[0][2] = arr[0][2];
		for(int i=1;i<n;i++){
			for(int j=0;j<3;j++){
				int num=0;
				if(j==0){
					num = Math.max(dp[i-1][0],dp[i-1][1]);
				}else if(j==1){
					num = max(dp[i-1]);
				}else if(j==2){
					num = Math.max(dp[i-1][1],dp[i-1][2]);
				}
				dp[i][j] = num + arr[i][j];
			}
		}

		int max = max(dp[n-1]);
		
		for(int i=1;i<n;i++){
			Arrays.fill(dp[i],0);
		}
		
		for(int i=1;i<n;i++){
			for(int j=0;j<3;j++){
				int num=0;
				if(j==0){
					num = Math.min(dp[i-1][0],dp[i-1][1]);
				}else if(j==1){
					num = min(dp[i-1]);
				}else if(j==2){
					num = Math.min(dp[i-1][1],dp[i-1][2]);
				}
				dp[i][j] = num + arr[i][j];
			}
		}
		int min = min(dp[n-1]);
		System.out.println(max+" "+min);
	}
	public static int max(int arr[]){
		int max=0;
		for(int i=0;i<3;i++){
			if(max<arr[i])
				max = arr[i];
		}
		return max;
	}
	public static int min(int arr[]){
		int min=Integer.MAX_VALUE;
		for(int i=0;i<3;i++){
			if(min>arr[i])
				min = arr[i];
		}
		return min;
	}
}
