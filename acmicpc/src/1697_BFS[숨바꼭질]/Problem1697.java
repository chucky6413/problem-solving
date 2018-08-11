/*
 * 2017.03.16
 * BFS ( ����ġ�� 1�̹Ƿ� )
 *
 * @problem https://www.acmicpc.net/problem/1697
 * @github https://github.com/chucky6413
 * @author chucky3
 */
import java.util.*;

public class Problem1697 {
	static int n,k,time[];
	static boolean visit[];
	static int MAX = 100000;
	public static void main(String arg[]){
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		k = input.nextInt();
		time = new int[MAX+1]; //�ð�
		visit = new boolean[MAX+1];
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(n);
		visit[n]=true;
		
		while(!queue.isEmpty()){
			int d = queue.poll();
			
			if(d-1>=0){
				if(visit[d-1]==false){
					queue.add(d-1);
					visit[d-1] = true; //�湮 Ȯ��
					time[d-1] = time[d]+1; //�ð� �߰�
				}
			}
			
			if(d+1<=MAX){
				if(visit[d+1]==false){
					queue.add(d+1);
					visit[d+1] = true;
					time[d+1] = time[d]+1;
				}
			}
			
			if(d*2<=MAX){
				if(visit[d*2]==false){
					queue.add(d*2);
					visit[d*2] = true;
					time[d*2] = time[d]+1;
				}
			}
		}
		
		System.out.println(time[k]);
	}
}