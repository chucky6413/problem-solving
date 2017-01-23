/*
 * 2017.01.23
 * 동적계획
 *
 * @problem https://www.acmicpc.net/problem/2306
 * @author chucky3
 */
import java.util.Arrays;
import java.util.Scanner;
public class Main {
	static char str[];
	static int dp[][];
	static String at="at",gc="gc";
	public static void main(String arg[]){
		Scanner input = new Scanner(System.in);
		str = input.next().toCharArray(); //입력
		int length = str.length;
		dp = new int[length][length];
		for(int i=0;i<length;i++) Arrays.fill(dp[i], -1); //계산 안된 값 -1 초기화
 		int result = solve(0,length-1); //재귀함수 호출
		System.out.println(result); //출력
	}
	public static int solve(int front,int back){
		if(front>=back) return 0;
		String ans=str[front]+""+str[back];
		if(dp[front][back]==-1){ //계산되지 않았을 때만
			dp[front][back] = 0;
			if(ans.equals(at) || ans.equals(gc)){
				dp[front][back] = solve(front+1,back-1) + 2; //a...t or g...c 일 때는~ 그 내부의 dp값 + 2
			}
			for(int i=front;i<back;i++){
				dp[front][back] = Math.max(solve(front,i)+solve(i+1,back), dp[front][back] ); //이어 붙인 값보다 큰지 검사. (최대값 찾기)
			}
		}
		
		return dp[front][back];
	}
}