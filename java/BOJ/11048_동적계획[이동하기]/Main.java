/*
 * 2017.01.20
 * µ¿Àû°èÈ¹
 *
 * @problem https://www.acmicpc.net/problem/11048
 * @github https://github.com/chucky6413
 * @author chucky3
 */
import java.util.*;

public class Main{
	static long dp[][];
	static int arr[][];
    public static void main(String arg[]){
        Scanner input = new Scanner(System.in);
    	int n = input.nextInt();
    	int m = input.nextInt();
    	
    	dp = new long[n][m];
    	arr = new int[n][m];
    	
    	for(int i=0;i<n;i++){
    		for(int j=0;j<m;j++){
    			arr[i][j] = input.nextInt();
    			
    			if(i==0 && j==0){
    				dp[0][0] = arr[0][0];
    			}else if(i==0){
    				dp[0][j] = dp[0][j-1] + arr[0][j];
    			}else if(j==0){
    				dp[i][0] = dp[i-1][0] + arr[i][0];
    			}else{
    				long max = Math.max(dp[i-1][j], Math.max(dp[i][j-1],dp[i-1][j-1]));
    				dp[i][j] = max + arr[i][j];
    			}
    		}
    	}
    	System.out.println(dp[n-1][m-1]);
    }
}