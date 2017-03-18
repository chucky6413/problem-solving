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
	static int lastP; //마지막 지워진 소수
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
			next = lastP;
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
				next = lastP * multi++; //배수 곱하기
			}
			if(result!=0){ //반복문 끝.
				break;
			}
		}
		System.out.println(result);
	}
	public static void primeSearch(){
		for(int i=lastP;i<=n;i++){
			if(arr[i]!=0){ //지워지지 않았을 때만,
				for(int j=i-1;j>=1;j--){
					if(j==1){
						lastP = i;
						return;
					}
					if(i%j==0){ //소수 아니면 넘기기.
						break;
					}else{ // 계속.
						continue;
					}
				}
			}
		}
	}
}