/*
 * 2017.03.18
 * BFS
 *
 * @problem https://www.acmicpc.net/problem/14226
 * @github https://github.com/chucky6413
 * @author chucky3
 */
import java.util.*;

public class Main {
	static int s,c,result;
	static int dist[][] = new int[1001][1001];
	static boolean visit[][] = new boolean[1001][1001];
	public static void main(String arg[]){
		Scanner input = new Scanner(System.in);
		
		result = input.nextInt();
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(1);
		queue.offer(0);
		
		while(!queue.isEmpty()){
			s = queue.poll();
			c = queue.poll();
			
			if(visit[s][s]==false){
				visit[s][s] = true;
				dist[s][s] = dist[s][c] + 1;
				queue.offer(s);
				queue.offer(s);
			}
			
			if(s+c<=1000 && visit[s+c][c]==false){
				visit[s+c][c] = true;
				dist[s+c][c] = dist[s][c] + 1;
				queue.offer(s+c);
				queue.offer(c);
			}
			
			if(s>1 && visit[s-1][c]==false){
				visit[s-1][c] = true;
				dist[s-1][c] = dist[s][c] + 1;
				queue.offer(s-1);
				queue.offer(c);
			}
		}
		
		int min = 10000000;
		for(int i=0;i<=1000;i++){
			if(visit[result][i]!=false && min>dist[result][i]){
				min = dist[result][i];
			}
		}
		System.out.println(min);
	}
}