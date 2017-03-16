/*
 * 2017.01.23
 * 동적계획
 *
 * @problem https://www.acmicpc.net/problem/2631
 * @github https://github.com/chucky6413
 * @author chucky3
 */
import java.util.Scanner;
public class Main {
	static int arr[],dp[],max=0;
	public static void main(String arg[]){
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		arr = new int[n];
		dp = new int[n];
		for(int i=0;i<n;i++) arr[i] = input.nextInt();
		// longest increasing subsequence
		for(int i=0;i<n;i++){
			for(int j=0;j<i;j++){
				if(arr[i]>arr[j] && dp[i]<dp[j]+1){
					dp[i] = dp[j]+1;
				}
			}
			if(max<dp[i])
				max=dp[i];
		}
		System.out.println((n-1)-max); //dp[0] = 0 부터 시작하므로, lis 가 -1만큼 작기 때문에 -1을 더 빼준다.
	}
}