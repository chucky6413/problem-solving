/*
 * 2017.01.23
 * 동적계획
 *
 * @problem https://www.acmicpc.net/problem/1003
 * @author chucky3
 */
import java.util.*;
public class Main {
	static int f[][] = new int[41][2];
	public static void main(String arg[]) throws Exception{
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		f[0][0] = 1; 
		f[0][1] = 0; 
		f[1][0] = 0;
		f[1][1] = 1;
		//계산
		for(int i=2;i<=40;i++){
			f[i][0] = f[i-1][0] + f[i-2][0];
			f[i][1] = f[i-1][1] + f[i-2][1];
		}
		//출력
		for(int i=0;i<t;i++){
			int k = input.nextInt();
			System.out.println(f[k][0]+" "+f[k][1]);
		}
	}
}