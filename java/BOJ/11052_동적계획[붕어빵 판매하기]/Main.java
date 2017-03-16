/*
 * 2017.01.18
 * µ¿Àû °èÈ¹
 *
 * @problem https://www.acmicpc.net/problem/11052
 * @github https://github.com/chucky6413
 * @author chucky3
 */
import java.util.*;

public class Main {
	static int dp[];
	static int price[];
	public static void main(String arg[]){
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int max;
		dp = new int[n+1];
		price = new int[n+1];
		dp[0]=0;
		for(int i=1;i<=n;i++){
			price[i] = input.nextInt();
			max=0;
			for(int j=1;j<=i;j++){
				if(price[j] + dp[i-j] > max)
					max = price[j] + dp[i-j];
			}
			dp[i] = max;
		}
		System.out.println(dp[n]);
	}
}