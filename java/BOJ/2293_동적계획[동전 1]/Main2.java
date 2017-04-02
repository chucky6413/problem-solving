/*
 * 2017.04.02
 * µ¿Àû°èÈ¹
 * 
 * @problem https://www.acmicpc.net/problem/2293
 * @github https://github.com/chucky6413
 * @author chucky3
 */
import java.util.*;

public class Main{
	static int n,k,sum=0;
	static int arr[];
	static int dp[];
	public static void main(String arg[]){
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		k = input.nextInt();
		arr = new int[n+1];
		dp = new int[k+1];
		
		for(int i=1;i<=n;i++){
			arr[i] = input.nextInt();
		}
		dp[0] = 1;
		for(int i=1;i<=n;i++){
			for(int j=arr[i];j<=k;j++){
				dp[j]+=dp[j-arr[i]]; 
			} 
		}
		
		System.out.println(dp[k]);
	}
}