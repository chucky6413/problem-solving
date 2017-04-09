/*
 * 2017.04.09
 * 탐색,정렬
 * 
 * @problem https://www.acmicpc.net/problem/1026
 * @github https://github.com/chucky6413
 * @author chucky3
 */
import java.util.*;
import java.io.*;

public class Main{
	static int n,s=0;
	static int a[];
	static Integer b[];
	public static void main(String arg[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tempA[],tempB[];
		
		n = Integer.parseInt(br.readLine());
		a = new int[n];
		b = new Integer[n];
		
		tempA = br.readLine().split(" ");
		tempB = br.readLine().split(" ");

		for(int i=0;i<n;i++){
			a[i] = Integer.parseInt(tempA[i]);
			b[i] = Integer.parseInt(tempB[i]);
		}
		//b의 가장 큰 것들과 a의 가장 작은 것들을 매칭해주면 된다.
		
		Arrays.sort(a);
		Arrays.sort(b,Collections.reverseOrder());
		for(int i=0;i<n;i++){ //계산.. function s()
			s+=(a[i]*b[i]);
		}
		System.out.println(s);
	}
}