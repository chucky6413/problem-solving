/*
 * 2017.01.10
 * ±¸Çö
 * 
 * @problem https://www.acmicpc.net/problem/11945
 * @github https://github.com/chucky6413/Algorithm-study/tree/master/java/BOJ
 * @author chucky3
 */
import java.util.Scanner;

public class Main {
	public static void main(String arg[]){
		Scanner input = new Scanner(System.in);
		input.nextLine();
		while(input.hasNext()){
			System.out.println(new StringBuilder(input.next()).reverse());
		}
		
	}
}