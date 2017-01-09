/*
 * 2017.01.10
 * 구현
 * 백준 11945
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