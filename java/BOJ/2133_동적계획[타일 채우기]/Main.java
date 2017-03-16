/*
 * 2017.01.20
 * µ¿Àû°èÈ¹
 *
 * @problem https://www.acmicpc.net/problem/2133
 * @github https://github.com/chucky6413
 * @author chucky3
 */
import java.util.*;

public class Main{
	static int dp[];
    public static void main(String arg[]){
        Scanner input = new Scanner(System.in);
    	int n= input.nextInt();
    	dp = new int[31];
    	dp[0] = 1;
    	for(int i=2;i<31;i++){
    		dp[i] = 3*dp[i-2];
    		for(int j=i-4;j>=0;j-=2){
    			dp[i] += 2*dp[j];
    		}
       	}
    	
    	System.out.println(dp[n]);
    }
}