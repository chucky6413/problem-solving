/*
 * 2017.06.09
 * 동적계획
 * 
 * @problem https://www.acmicpc.net/problem/1038
 * @github https://github.com/chucky6413
 * @author chucky3
 */

import java.util.*;

public class Main {
	static int n,cnt;
	static long arr[] = new long[1500];
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		Arrays.fill(arr, Long.MAX_VALUE);
		find(0,10);
		Arrays.sort(arr);
		if(n>=cnt) System.out.println("-1");
		else System.out.println(arr[n]);
	}
	public static void find(long curNum, long end){
		// 0 , 10  0<10  / 0 , i=1-> 10 , 1 , i=2-> 20 , 210 , 21 , 2 i=3->30 , 310 , 31 , 320 , 3210 , 321 , 32 , 3 ...
		for(long i=curNum;i<curNum+end;i++){
			if(i%10>0){ // 내려갈 수 있는 가능성 있는 수는 증가시키며 만들어 나간다. 곱하기 10을 하면 하나 내려갈 수 있어짐.
				find(i*10,i%10);
			}
			arr[cnt] = i;
			cnt++;
		}
		
		//가장 큰 감소하는 수 9876543210 1022번째.
	}
}