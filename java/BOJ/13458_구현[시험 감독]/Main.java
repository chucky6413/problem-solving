/*
 * 2017.04.19
 * ±¸Çö
 * 
 * @problem https://www.acmicpc.net/problem/13458
 * @github https://github.com/chucky6413
 * @author chucky3
 */
import java.util.*;
import java.io.*;

public class Main{
	static int n;
	static int arr[];
	static int b,c;
	static long count=0;
	public static void main(String arg[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp[];
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		temp = br.readLine().split(" ");
		for(int i=0;i<n;i++){
			arr[i] = Integer.parseInt(temp[i]);
		}
		temp = br.readLine().split(" ");
		b = Integer.parseInt(temp[0]);
		c = Integer.parseInt(temp[1]);
		
		count = n;
		for(int i=0;i<n;i++){
			arr[i]-=b;
			if(arr[i]<0)
				arr[i] = 0;
			int div = arr[i]/c;
			int mod = arr[i]%c;
			if(mod!=0){
				count++;
			}
			count+=div;
		}
		
		System.out.println(count);
	}
}