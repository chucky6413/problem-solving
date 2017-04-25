/*
 * 2017.04.25
 * µ¿Àû°èÈ¹
 * 
 * @problem https://www.acmicpc.net/problem/1699
 * @github https://github.com/chucky6413
 * @author chucky3
 */

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	static int n;
	static int memo[];
	static int dp[];
	public static void main(String args[]) throws IOException{
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		dp = new int[n+1];
		memo = new int[n+1];
		int k = 0;
		for(int i=1;i*i<=n;i++) memo[k++] = i*i;
		Arrays.fill(dp, 10000);
		for(int i=0;i<k;i++){
			dp[memo[i]] = 1;
			for(int j=memo[i];j<=n;j++){
				dp[j] = Math.min(dp[j], dp[j-memo[i]]+1);
			}
		}
		System.out.println(dp[n]);
	}
}
