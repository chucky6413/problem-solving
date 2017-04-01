/*
 * 2017.04.01
 * Èü-Áß¾Ó°ª
 * 
 * @problem https://www.acmicpc.net/problem/1655
 * @github https://github.com/chucky6413
 * @author chucky3
 */
import java.util.*;
import java.io.*;

public class Main {
	static int n,mid;
	static final String NEWLINE = "\n";
	public static void main(String arg[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder()); //¿ÞÂÊ
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(); //¿À¸¥ÂÊ
		
		n = Integer.parseInt(br.readLine());
		
		for(int i=1;i<=n;i++){
			int num = Integer.parseInt(br.readLine());
			
			if(i==1){
				mid=num;
				sb.append(mid+NEWLINE);
				continue;
			}
				
			if(num<mid){
				maxHeap.offer(num);
			}else{
				minHeap.offer(num);
			}
				
			if(i%2==1){ //È¦¼ö
				if(maxHeap.size()==minHeap.size()){ //maxHeap - leftHeap , minHeap - rightHeap
					
				}else if(maxHeap.size()>minHeap.size()){ //leftHeap ÀÌ ¸¹À» °æ¿ì
					minHeap.offer(mid);
					mid = maxHeap.poll();
				}else{ //rightHeap ÀÌ ¸¹À» °æ¿ì
					maxHeap.offer(mid);
					mid = minHeap.poll();
				}
				sb.append(mid+NEWLINE);
			}else{ //Â¦¼ö
				if(maxHeap.size()>minHeap.size()){
					sb.append(maxHeap.peek()+NEWLINE);
				}else{
					sb.append(mid+NEWLINE);
				}
			}
		}
		System.out.println(sb);
	}
}

