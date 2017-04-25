/*
 * 2017.04.25
 * µ¿Àû°èÈ¹
 * 
 * @problem https://www.acmicpc.net/problem/1965
 * @github https://github.com/chucky6413
 * @author chucky3
 */

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	static int n;
	static int arr[];
	static int dp[];
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp[];
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		dp = new int[n];
		temp = br.readLine().split(" ");
		for(int i=0;i<n;i++){
			arr[i] = Integer.parseInt(temp[i]);
		}
		for(int i=0;i<n;i++){
			dp[i] = 1;
			for(int j=0;j<i;j++){
				if(arr[i]>arr[j] && dp[j]+1>dp[i]){
					dp[i]+=1;
				}
			}
		}
		int max = 0;
		for(int i=0;i<n;i++){
			if(dp[i]>max){
				max = dp[i];
			}
		}
		System.out.println(max);
	}
}
