/*
 * 2016.8.29
 * 최소값 찾기,최소 슬라이딩 윈도우 알고리즘
 *
 * @problem https://www.acmicpc.net/problem/11003
 * @github https://github.com/chucky6413
 * @author chucky3
 *
 * deque(덱) 자료구조를 사용하여 숫자 저장한 array의 index를 관리하고
 * 비교 대상의 마지막 인덱스와 비교하여 앞의 저장 값들이 클 경우 모두 제거.. 최솟값의 인덱스만을 갖고 가는 알고리즘..
 */

import java.util.StringTokenizer;
import java.util.LinkedList;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
	public static void main(String arg[]) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine()," ");
		int nums[] = new int[n];
		int k = 0;
		while(st.hasMoreTokens()){
			nums[k] = Integer.parseInt(st.nextToken());
			k++;
		}
		
		StringBuilder sb = new StringBuilder();
		LinkedList<Integer> deque = new LinkedList<Integer>();
		
	    for(int i=0; i<n; i++){
	        if(!deque.isEmpty()&&deque.peekFirst()==i-l) // l 값 3개 될때마다 맨앞 덱 제거
	            deque.poll();
	 
	        while(!deque.isEmpty()&&nums[deque.peekLast()]>nums[i]){ 
	            deque.removeLast();
	        }    
	 
	        deque.offer(i);
	 
	        sb.append(nums[deque.peek()]+" ");
	    }
	    System.out.println(sb);
	}
}