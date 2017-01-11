/*
 * 2016.12.04
 *
 * @problem https://www.acmicpc.net/problem/10799
 * @author chucky3
 */
import java.util.Scanner;

public class Main {
	public static void main(String arg[]){
		Scanner sc = new Scanner(System.in);
		int height=0,result=0;
		String s = sc.next();
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=='('){ //막대 높이 증가
				height++; 
			}else{
				height--;
				if(s.charAt(i-1)=='('){ //레이저
					result+=height;
				}else
					result++;
			}
		}
		System.out.println(result);
	}
}