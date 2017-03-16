/*
 * 2017.01.18
 * 동적 계획
 *
 * @problem https://www.acmicpc.net/problem/10844
 * @github https://github.com/chucky6413
 * @author chucky3
 */
import java.util.*;

public class Main {
	static long dp[][];
	static long mod=1000000000,result=0;
	public static void main(String arg[]){
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
	
		dp = new long[n+1][10];
		for(int i=1;i<=9;i++) dp[1][i] = 1; //길이 1, i로 끝날 경우의 수.
		for(int i=2;i<=n;i++){
			for(int j=0;j<=9;j++){
				if(j==0)
					dp[i][j] = dp[i-1][j+1]%mod;
				else if(j==9)
					dp[i][j] = dp[i-1][j-1]%mod;
				else
					dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1])%mod;
			}
		}
		for(int i=0;i<=9;i++){
			result+=dp[n][i];
		}
		System.out.println(result%mod);
	}
}