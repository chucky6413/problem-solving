/*
 * 2017.04.01
 * 힙-중앙값
 * 
 * @problem https://www.acmicpc.net/problem/2696
 * @github https://github.com/chucky6413
 * @author chucky3
 */
import java.util.*;
import java.io.*;

public class Main {
	static int T,n,mid;
	static final String NEWLINE = "\n";
	public static void main(String arg[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String temp[] = null;
		
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder()); //왼쪽
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(); //오른쪽
		
		T = Integer.parseInt(br.readLine());
		
		while(T-->0){
			n = Integer.parseInt(br.readLine());
			maxHeap.clear();
			minHeap.clear();
			sb.append((n/2)+1+NEWLINE);
			for(int i=1;i<=n;i++){
				if((i%10)==1){
					temp = br.readLine().split(" ");
				}
				int num = Integer.parseInt(temp[(i-1)%10]);
				
				if(i==1){
					mid=num;
					sb.append(mid+" ");
					continue;
				}
				
				if(num<mid){
					maxHeap.offer(num);
				}else{
					minHeap.offer(num);
				}
				
				if(i%2==1){ //홀수
					if(maxHeap.size()==minHeap.size()){ //maxHeap - leftHeap , minHeap - rightHeap
						
					}else if(maxHeap.size()>minHeap.size()){ //leftHeap 이 많을 경우
						minHeap.offer(mid);
						mid = maxHeap.poll();
					}else{ //rightHeap 이 많을 경우
						maxHeap.offer(mid);
						mid = minHeap.poll();
					}
					sb.append(mid+" ");
				}
				if((i%20)==0) sb.append(NEWLINE);
			}
			sb.append(NEWLINE);
		}
		System.out.println(sb);
	}
}

