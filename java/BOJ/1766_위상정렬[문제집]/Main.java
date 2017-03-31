/*
 * 2017.03.31
 * À§»óÁ¤·Ä, Èü
 * 
 * @problem https://www.acmicpc.net/problem/1766
 * @github https://github.com/chucky6413
 * @author chucky3
 */
import java.util.*;

public class Main {
	static LinkedList<Integer>[] list;
	static int prev[];
	public static void main(String arg[]){
		Scanner input = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = input.nextInt();
		int m = input.nextInt();
		list = new LinkedList[n+1];
		prev = new int[n+1];
		
		for(int i=1;i<=n;i++){
			list[i] = new LinkedList<Integer>();
		}
		for(int i=0;i<m;i++){
			int a = input.nextInt();
			int b = input.nextInt();
			list[a].add(b);
			prev[b]++;
		}
		
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		for(int i=1;i<=n;i++){
			if(prev[i]==0){
				queue.add(i);
			}
		}
		while(!queue.isEmpty()){
			int q = queue.poll();
			sb.append(q+" ");
			for(int next : list[q]){
				prev[next]--;
				if(prev[next]==0){
					queue.add(next);
				}
			}
		}
		System.out.println(sb);
	}
}