/*
 * 2017.04.02
 * 동적계획
 * 
 * @problem https://www.acmicpc.net/problem/2294
 * @github https://github.com/chucky6413
 * @author chucky3
 */
import java.util.*;

public class Main{
	static int n,k;
	static int arr[] = new int[101];
	static int dp[] = new int[10001];
	public static void main(String arg[]){
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		k = input.nextInt();
		
		for(int i=1;i<=n;i++){
			arr[i] = input.nextInt();
		}
		Arrays.fill(dp, 10001);
		for(int i=1;i<=n;i++){
			if(arr[i]>10000) continue; //함정 .. 주어지는 동전의 가치가 10000이하라고는 안했다..
			dp[arr[i]] = 1; //1이 최솟값 이므로
			for(int j=arr[i];j<=k;j++){
				dp[j] = Math.min(dp[j], dp[j-arr[i]]+1);
			} 
		}
		//System.out.println(Arrays.toString(dp));
		
		System.out.println(dp[k]==10001?-1:dp[k]);
	}
}