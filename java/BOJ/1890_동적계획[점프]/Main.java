/*
 * 2017.01.20
 * µ¿Àû°èÈ¹
 *
 * @problem https://www.acmicpc.net/problem/1890
 * @github https://github.com/chucky6413/Algorithm-study/tree/master/java/BOJ
 * @author chucky3
 */
import java.util.*;

public class Main{
	static long dp[][];
	static int arr[][];
    public static void main(String arg[]){
        Scanner input = new Scanner(System.in);
    	int n = input.nextInt();
    	
    	dp = new long[n][n];
    	arr = new int[n][n];
    	dp[0][0] = 1;
    	for(int i=0;i<n;i++){
    		for(int j=0;j<n;j++){
    			if(i==n-1 && j==n-1) continue; //µµÂøÁ¡
    			arr[i][j] = input.nextInt();
    			int jump = arr[i][j];
    			if(i+jump<n){
    				dp[i+jump][j]+=dp[i][j];
    			}
    			if(j+jump<n){
    				dp[i][j+jump]+=dp[i][j];
    			}
    		}
    	}
    	System.out.println(dp[n-1][n-1]);
    }
}