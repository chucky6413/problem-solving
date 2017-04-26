/*
 * 2017.04.26
 * µ¿Àû°èÈ¹
 * 
 * @problem https://www.acmicpc.net/problem/9251
 * @github https://github.com/chucky6413
 * @author chucky3
 */

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	static String s1,s2;
	static int dp[][];
	public static void main(String args[]) throws IOException{
		Scanner input = new Scanner(System.in);
		s1 = input.next();
		s2 = input.next();
		dp = new int[s1.length()][s2.length()];
		
		for(int i=0;i<s1.length();i++){
			for(int j=0;j<s2.length();j++){
				if(s1.charAt(i)==s2.charAt(j)){
					if(i==0 || j==0)
						dp[i][j] = 1;
					else
						dp[i][j] = dp[i-1][j-1] + 1;
				}else{
					if(i==0&&j==0)
						dp[i][j] = 0;
					else if(i==0)
						dp[i][j] = dp[i][j-1];
					else if(j==0)
						dp[i][j] = dp[i-1][j];
					else
						dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		input.close();
		System.out.println(dp[s1.length()-1][s2.length()-1]);
	}
}
