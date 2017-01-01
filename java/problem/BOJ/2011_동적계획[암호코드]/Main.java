/*
 * 2016.11.14
 * 다이나믹프로그래밍.
 * 백준 2011
 */
import java.util.Scanner;

public class Main {
	public static void main(String arg[]){
		Scanner input = new Scanner(System.in);
		
		String password = input.next();
		int len = password.length();
		int result[] = new int[len+1];
		
		if(len>=1){ //초기 값
			result[0] = 1;
			result[1] = 1;
		}
		
		if(password.charAt(0)=='0'){
			//0으로 시작하면 X
			result[1] = 0;
		}else{
			for(int i=2;i<len+1;i++){
				if(!(password.charAt(i-2)=='1' || password.charAt(i-2)=='2') && password.charAt(i-1)=='0'){ //예외상황
					result[len] = 0;
					break;
				}
				if(password.charAt(i-1)=='0'){ // 10 or 20 일 때
					result[i] = result[i-2];
				}else if((password.charAt(i-2)=='1'&& password.charAt(i-1)<='9')||((password.charAt(i-2)=='2')&& password.charAt(i-1)<='6')){
					result[i]=(result[i-1]+result[i-2])%1000000; // //2개로 나뉠 때, 증가할 때만 나머지 처리..
				}else{
					result[i]=result[i-1];
				}
			}
		}
		System.out.println(result[len]);
	}
}