/*
 * 2017.03.18
 * 정수론,에라토스테네스의 체
 *
 * @problem https://www.acmicpc.net/problem/6588
 * @github https://github.com/chucky6413
 * @author chucky3
 */
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int question[] = new int[1000001];
	static int n,index=0;
	public static void main(String arg[]){
		Scanner input = new Scanner(System.in);
		
		while((n = input.nextInt())!=0){
			question[index++] = n;
		}
		
		for(int i=0;i<index;i++){
			search(question[i]);
		}
		
		System.out.println(sb);
	}
	public static void search(int num){
		int resultA=0,resultB=0;
		
		for(int i=3;i<=num/2;i+=2){
			if(isPrimeNumber(i)){
				if(isPrimeNumber(num-i)){
					resultA = i;
					resultB = num-i;
				}
			}
			if(resultA!=0){
				break;
			}
		}
		
		if(resultA==0)
			sb.append("Goldbach's conjecture is wrong\n");
		else
			sb.append(num+" = "+resultA+" + "+resultB+"\n");
	}
	public static boolean isPrimeNumber(int num){
		for(int i=2;i<num/2;i++){ 
			if(num%i==0){
				return false;
			}
		}
		return true;
	}
}