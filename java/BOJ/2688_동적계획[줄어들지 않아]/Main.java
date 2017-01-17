/*
 * 2017.01.18
 * 동적계획
 *
 * @problem https://www.acmicpc.net/problem/2688
 * @author chucky3
 */
import java.util.Scanner;
import java.util.*;

public class Main {
	static long dp[],arr[][];
	static int answer[],max=0;
	
	public static void main(String arg[]){
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		answer = new int[t]; //출력할 목록
		for(int i=0;i<t;i++){
			answer[i]=input.nextInt();
			if(max<answer[i])
				max=answer[i];
		}
		dp = new long[max+1]; //구할 값 (dp로)
		arr = new long[max+1][10];
		dp[0] = 1;
		for(int i=1;i<=max;i++){
			arr[i][0] = dp[i-1];
			dp[i]+=arr[i][0];
			for(int j=1;j<10;j++){
				arr[i][j] = arr[i][j-1] - arr[i-1][j-1];
				dp[i]+=arr[i][j];
			}
		}
		//출력
		for(int i=0;i<t;i++){
			System.out.println(dp[answer[i]]);
		}
	}
}