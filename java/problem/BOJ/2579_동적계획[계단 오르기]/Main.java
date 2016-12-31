/*
 * 2017.01.01
 * 동적계획
 * 백준 2579
 */
import java.util.*;

public class Main {
	static int n;
	static int arr[],memo[];
	public static void main(String arg[]){
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		arr = new int[n+1];
		memo = new int[n+1];
		
		for(int i=1;i<=n;i++){
			arr[i] = input.nextInt();
		}
		for(int i=1;i<=n;i++){
			int a=0,b=0;
			if(i<3)
				memo[i]=memo[i-1]+arr[i];
			else{
				a = memo[i-2] + arr[i]; //oxo
				b = memo[i-3] + arr[i-1] + arr[i]; //oxoo

				int max = a>b?a:b;
				memo[i]=max;
			}
 		}
		System.out.println(memo[n]);
	}
}