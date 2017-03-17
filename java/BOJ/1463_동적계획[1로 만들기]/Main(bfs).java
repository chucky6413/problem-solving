/*
 * 2017.03.17
 * BFS
 *
 * @problem https://www.acmicpc.net/problem/1463
 * @github https://github.com/chucky6413
 * @author chucky3
 */
import java.util.*;

public class Main {
	static int n; //입력 받을 정수
	static int cost[]; //비용 배열
	static boolean visit[]; //방문 했는지
	public static void main(String arg[]){
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		cost = new int[n+1]; //비용 배열
		visit = new boolean[n+1]; //방문했는지

		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(n);
		
		while(!queue.isEmpty()){ //큐가 비어있지 않다면
			int k = queue.poll(); //큐의 맨 앞 추출
			
			if(k%3==0 && visit[k/3]==false){ //k가 3으로 나누어 떨어진다면
				cost[k/3] = cost[k] + 1;
				visit[k/3] = true;
				queue.offer(k/3);
			}
			
			if(k%2==0 && visit[k/2]==false){ //k가 2로 나누어 떨어진다면
				cost[k/2] = cost[k] + 1;
				visit[k/2] = true;
				queue.offer(k/2);
			}
			
			if(k-1>1 && visit[k-1]==false){ //k-1이 1보다 크다면
				cost[k-1]= cost[k] + 1;
				visit[k-1] = true;
				queue.offer(k-1);
			}
		}
		
		System.out.println(cost[1]); //정답 출력
	}
}