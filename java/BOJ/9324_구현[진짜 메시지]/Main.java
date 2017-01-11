/*
 * 2017.01.10
 * 구현
 *
 * @problem https://www.acmicpc.net/problem/9324
 * @author chucky3
 */
import java.util.Scanner;
import java.util.Arrays;

public class Main {
	static int[] count = new int[26];
	public static void main(String arg[]){
		Scanner input = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int test_case = input.nextInt();
		
		for(int i=0;i<test_case;i++){
			String s = input.next();
			String result = "OK";
			for(int j=0;j<s.length();j++){ //작업
				char c = s.charAt(j); 
				int index = (int)c-65;
				
				count[index]++; //문자에 해당하는 자리 증가
				if((count[index]%3)==0){ //3번째 나타날 때 마다
					if(j!=s.length()-1 && s.charAt(j+1)==c){//다음 자리가 한번 더 삽입 되었는가?
						j++;
					}else{ //아니라면 정지
						result="FAKE";
						break; 
					}
				}
			}
			sb.append(result+"\n");
			Arrays.fill(count,0); //초기화
		}
		System.out.println(sb);
	}
}