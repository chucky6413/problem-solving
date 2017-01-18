/*
 * 2017.01.18
 * 동적 계획
 *
 * dp[i-1] 1X2로 채우는 수 + dp[i-2] 2X1로 채우는 수
 * @problem https://www.acmicpc.net/problem/11726
 * @author chucky3
 */
import java.util.*;

public class Main {
	static int dp[];
	public static void main(String arg[]){
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		dp = new int[n+1];
		if(n>0) dp[1] = 1;	
		if(n>1)	dp[2] = 2;
		for(int i=3;i<=n;i++){
			dp[i] = (dp[i-1] + dp[i-2])%10007;
		}
		
		System.out.println(dp[n]);
	}
}