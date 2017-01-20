/*
 * 2017.01.20
 * µ¿Àû°èÈ¹
 *
 * @problem https://www.acmicpc.net/problem/9461
 * @author chucky3
 */
import java.util.*;

public class Main{
	static long dp[];
    public static void main(String arg[]){
        Scanner input = new Scanner(System.in);
    	int t = input.nextInt();
        
        dp = new long[101];
    	dp[1] = dp[2] = dp[3] = 1;
    	dp[4] = dp[5] = 2;
    	
    	for(int i=6;i<=100;i++){
    		dp[i] = dp[i-1]+dp[i-5];
    	}
    	
    	for(int i=0;i<t;i++){
    		int n = input.nextInt();
    		System.out.println(dp[n]);
    	}
    }
}