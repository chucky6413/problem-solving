/*
 * 2017.04.01
 * ��-�߾Ӱ�
 * 
 * @problem https://www.acmicpc.net/problem/1655
 * @github https://github.com/chucky6413
 * @author chucky3
 */
import java.util.*;
import java.io.*;

public class Problem1655 {
	static int n,mid;
	static final String NEWLINE = "\n";
	public static void main(String arg[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder()); //����
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(); //������
		
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
				
			if(i%2==1){ //Ȧ��
				if(maxHeap.size()==minHeap.size()){ //maxHeap - leftHeap , minHeap - rightHeap
					
				}else if(maxHeap.size()>minHeap.size()){ //leftHeap �� ���� ���
					minHeap.offer(mid);
					mid = maxHeap.poll();
				}else{ //rightHeap �� ���� ���
					maxHeap.offer(mid);
					mid = minHeap.poll();
				}
				sb.append(mid+NEWLINE);
			}else{ //¦��
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

