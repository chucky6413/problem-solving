/*
 * 2017.01.10
 * ¼öÇÐ
 * 
 * @problem https://www.acmicpc.net/problem/1834
 * @author chucky3
 */
import java.util.Scanner;

public class Main {
	public static void main(String arg[]){
		Scanner input = new Scanner(System.in);
		long n = input.nextInt();
		long result = 0;
		for(int i=1;i<n;i++){
			result+=(n*i)+i;
		}
		System.out.println(result);
	}
}