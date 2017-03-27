/*
 * 2017.03.27
 * DFS N이 10이므로, 10! -> 360만 .. 아주 작은숫자다.
 * 이 코드는 N! 효율적이지 않음.
 *
 * @problem https://www.acmicpc.net/problem/10971
 * @github https://github.com/chucky6413
 * @author chucky3
 */
import java.util.*;

public class Main {
	static int n,min=10000001;
	static boolean visit[] = new boolean[11];
	static int w[][] = new int[11][11]; 
	public static void main(String arg[]){
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		
		for(int i=1;i<=n;i++){
			for(int j=1;j<=n;j++){
				w[i][j] = input.nextInt();
			}
		}
		
		for(int i=1;i<=n;i++){
			solve(i,i,1,0);
		}
		
		System.out.println(min);
	}
	public static void solve(int start,int cur,int depth,int cost){ //dfs 이용하여 처리.
		if(depth==n){
			if(w[cur][start]==0){ //도착점으로 돌아갈 수 없을때를 예외처리 
				return;
			}
			
			cost += w[cur][start];
			if(cost<min){
				min = cost;
			}
			return;
		}

		visit[cur] = true;
		
		for(int i=1;i<=n;i++){
			if(!visit[i] && w[cur][i]!=0){
				solve(start,i,depth+1,cost+w[cur][i]);
			}
		}
		
		visit[cur] = false;
	}
}