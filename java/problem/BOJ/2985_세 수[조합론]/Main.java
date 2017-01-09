/*
 * 2017.01.10
 * 조합론
 * 백준 2985
 */
import java.util.Scanner;

public class Main {
	public static void main(String arg[]){
		Scanner input = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int a = input.nextInt();
		int b = input.nextInt();
		int c = input.nextInt();
		
		if((a+b)==c){
			sb.append(a+"+"+b+"="+c);
		}else if((a-b)==c){
			sb.append(a+"-"+b+"="+c);
		}else if((a*b)==c){
			sb.append(a+"*"+b+"="+c);
		}else if((a/b)==c){
			sb.append(a+"/"+b+"="+c);
		}else if(a==(b+c)){
			sb.append(a+"="+b+"+"+c);
		}else if(a==(b-c)){
			sb.append(a+"="+b+"-"+c);
		}else if(a==(b*c)){
			sb.append(a+"="+b+"*"+c);
		}else if(a==(b/c)){
			sb.append(a+"="+b+"/"+c);
		}
		
		System.out.println(sb);
	}
}