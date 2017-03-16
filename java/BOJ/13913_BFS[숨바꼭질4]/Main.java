/*
 * 2017.03.16
 * BFS ( 가중치가 1이므로 )
 *
 * @problem https://www.acmicpc.net/problem/13913
 * @github https://github.com/chucky6413
 * @author chucky3
 */
import java.util.*;

public class Main {
	static int n,k,time[],from[];
	static boolean visit[];
	static int MAX = 100000;
	public static void main(String arg[]){
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		k = input.nextInt();
		time = new int[MAX+1]; //시간
		visit = new boolean[MAX+1]; //방문
		from = new int[MAX+1]; //어디서 왔는지
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(n);
		visit[n]=true;
		
		while(!queue.isEmpty()){
			int d = queue.poll();
			
			if(d-1>=0){
				if(visit[d-1]==false){
					queue.add(d-1);
					visit[d-1] = true; //방문 확인
					time[d-1] = time[d]+1; //시간 추가
					from[d-1] = d; //어디서 왔는지
				}
			}
			
			if(d+1<=MAX){
				if(visit[d+1]==false){
					queue.add(d+1);
					visit[d+1] = true;
					time[d+1] = time[d]+1;
					from[d+1] = d;
				}
			}
			
			if(d*2<=MAX){
				if(visit[d*2]==false){
					queue.add(d*2);
					visit[d*2] = true;
					time[d*2] = time[d]+1;
					from[d*2] = d;
				}
			}
		}
		
		System.out.println(time[k]);
		printFrom(n,k);
	}
	public static void printFrom(int n, int k){ //시작점 , 도착점
		if(n!=k){
			printFrom(n,from[k]); //도착점이 어디서 왔는지.
		}
		System.out.print(k+" ");
	}
}