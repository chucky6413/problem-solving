/*
 * 2017.01.10
 * 동적 계획,수학,문자열 처리
 * 백준 1464
 * ABDAA
 * BCDAF
 * EBA
 * EBC
 */
import java.util.Scanner;

public class Main {
	static StringBuilder sb;
	static StringBuilder temp;
	public static void main(String arg[]){
		Scanner input = new Scanner(System.in);
		sb  = new StringBuilder(input.next());
		
		for(int i=1;i<sb.length();i++){
			if(i==(sb.length()-1) && ( sb.charAt(0)>sb.charAt(i) )){
				reverse(i);
			}else if( i<sb.length()-1 && (sb.charAt(0)<sb.charAt(i) && sb.charAt(i+1)<=sb.charAt(0) ) ||
					sb.charAt(i)<sb.charAt(0) && (sb.charAt(i+1)>sb.charAt(0) || sb.charAt(i)<sb.charAt(i+1)) ){
				reverse(i);
			}
		}
		System.out.println(sb.toString());
	}
	public static void reverse(int i){
		temp = new StringBuilder(sb.substring(0, i+1));
		temp.reverse();
		sb.replace(0, i+1, temp.toString());
	}
}