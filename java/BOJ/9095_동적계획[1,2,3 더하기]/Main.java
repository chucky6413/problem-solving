/*
 * 2017.01.18
 * µ¿Àû °èÈ¹
 *
 * @problem https://www.acmicpc.net/problem/9095
 * @github https://github.com/chucky6413/Algorithm-study/tree/master/java/BOJ
 * @author chucky3
 */
import java.util.*;

public class Main {
	static int dp[];
	static int answer[];
	public static void main(String arg[]){
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		int max = 0;
		answer = new int[t];
		for(int i=0;i<t;i++){
			answer[i] = input.nextInt();
			if(answer[i]>max)
				max=answer[i];
		}
		dp = new int[max+1];
		if(max>0) dp[1] = 1;	
		if(max>1) dp[2] = 2;
		if(max>2) dp[3] = 4;
		for(int i=4;i<=max;i++){
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		}
		
		for(int i=0;i<t;i++){
			System.out.println(dp[answer[i]]);
		}
	}
}