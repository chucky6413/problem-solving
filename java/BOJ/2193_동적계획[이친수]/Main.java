/*
 * 2016.12.12
 * 동적 계획법
 *
 * @problem https://www.acmicpc.net/problem/2193
 * @github https://github.com/chucky6413
 * @author chucky3
 *
 * f(n)=f(n-1)+f(n-2)..
 */
import java.util.Scanner;

public class Main {
	static int n;
	static long count[] = new long[91];
	public static void main(String arg[]){
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		count[0]=0;
		count[1]=1;
		for(int i=2;i<=n;i++){
			count[i]=count[i-1]+count[i-2];
		}
		System.out.println(count[n]);
	}
}
