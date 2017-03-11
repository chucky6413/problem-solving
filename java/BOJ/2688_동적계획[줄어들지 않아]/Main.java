/*
 * 2017.01.18
 * 동적계획
 *
 * @problem https://www.acmicpc.net/problem/2688
 * @github https://github.com/chucky6413/Algorithm-study/tree/master/java/BOJ
 * @author chucky3
 */
import java.util.Scanner;
import java.util.*;

public class Main {
	static long dp[][],result[];
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
		dp = new long[max+1][10];
		for(int i=0;i<=9;i++) dp[1][i]=1; //i로 끝날 때 경우의 수
		for(int i=2;i<=max;i++){
			for(int j=0;j<=9;j++){
				for(int k=0;k<=j;k++){
					dp[i][j] += dp[i-1][k]; // dp[i][j] 는 dp[i-1][j보다 작은 애들의] 합 이다.
				}
			}
		}
		
		result = new long[t];
		for(int i=0;i<t;i++){
			for(int j=0;j<=9;j++){
				result[i]+=dp[answer[i]][j]; //계산
			}
			System.out.println(result[i]); //출력
		}
	}
}