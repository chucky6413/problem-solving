/*
 * 2017.03.18
 * 구현,에라토스테네스의 체
 *
 * @problem https://www.acmicpc.net/problem/2960
 * @github https://github.com/chucky6413
 * @author chucky3
 */
import java.util.*;

public class Main {
	static int currentPrime;
	static int n,k,count,next,result;
	static int arr[];
	public static void main(String arg[]){
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		k = input.nextInt();
		
		arr = new int[n+1];
		
		for(int i=2;i<=n;i++){
			arr[i] = i;
		}
		
		while(count!=(n-1)){ //지운 수가 n-1개 일 때 까지 반복
			primeSearch();
			next = currentPrime;
			int multi = 2; //배수 곱할 것.
			while(next<=n){
				if(arr[next]!=0){ //지워지 않은 애들.
					arr[next] = 0;
					count++;
				}
				if(count==k){ //찾았을 때,
					result = next;
					break;
				}
				next = currentPrime * multi++; //배수 곱하기
			}
			if(result!=0){ //반복문 끝.
				break;
			}
		}
		System.out.println(result);
	}
	public static void primeSearch(){
		for(int i=currentPrime;i<=n;i++){
			if(arr[i]!=0){ //지워지지 않았을 때만,
				if(isPrimeNumber(i)){
					currentPrime = i;
					break;
				}
			}
		}
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