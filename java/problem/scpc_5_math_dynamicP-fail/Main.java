/*
 * 2016.9.14
 * 작성자:이준우
 * 수학 공식 + 다이나믹 프로그래밍(반복되는 부분 제거)
 * 하지만 틀림..
 * 조합, 페르마의 소정리, 나머지 연산의 곱에 대한 역원에 대해 알아야 한다고 함 ㅠㅠ
 */

import java.util.Scanner;
import java.lang.ArithmeticException;

public class Main{
	public static final int mod = 1000000007;
	
	public static void main(String arg[]){
		Scanner input = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int t = input.nextInt();
		
		for(int i=1;i<=t;i++){
			int n = input.nextInt();
			int m = input.nextInt();
			
			int result = 0; 
			
			if(n==0 && m==0){
				result = 0;
			}else if(m==0){
				result = n+1;
			}else if(n==0){
				result = m+1;
			}else{
				int top[] = new int[n+2]; //분자
				int bottom[] = new int[n+2]; //분모
				
				top[0] = 1;
				bottom[0] = 1;
				
				for(int j=1;j<=n+1;j++){
					
					top[j] = (m+j)*top[j-1];
					bottom[j] = j*bottom[j-1]; 
					
					try{
						result+=(top[j]/bottom[j]);
					}catch(ArithmeticException e){
						
					}
				}
			}
			sb.append("Case #" + i +"\n"+(result%mod)+"\n");
		}
		System.out.print(sb);
	}
}