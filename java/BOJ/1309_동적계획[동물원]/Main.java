/*
 * 2017.04.26
 * µ¿Àû°èÈ¹
 * 
 * @problem https://www.acmicpc.net/problem/1309
 * @github https://github.com/chucky6413
 * @author chucky3
 */

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	static int n;
	static int dp[];
	public static void main(String args[]) throws IOException{
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		dp = new int[n+1];
		dp[0] = 1;
		dp[1] = 3;
		for(int i=2;i<=n;i++){
			dp[i] = dp[i-1]*2 + dp[i-2];
			dp[i]%=9901;
		}
		System.out.println(dp[n]);
	}
}
