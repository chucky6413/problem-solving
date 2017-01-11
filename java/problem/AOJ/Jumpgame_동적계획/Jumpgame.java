/*
 * 알게 된 점. 동적 계획 알고리즘으로 문제를 풀 때 ..
 * 1. 완전 탐색
 * 2. 주복된 부분 문제를 한 번만 계산하도록 메모이제이션을 적용 ..
 * 
 * but visited 배열을 .. boolean 으로 true,false 로만 처리할 때 보다 ,,
 * int 형으로 하여 방문되지 않은 경우, false 인 경우, true 인 경우 3가지로 나눠서
 * 처리 할때가 속도가 더 빨랐고 문제를 해결 할 수 있었음.
 *
 * @author chucky3
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Jumpgame {
	static int arr[][];
	static int visited[][];
	static final int YES = 2;
	static final int NO = 1;
	static final int NOT_VISITED = 0;
	static int size;
	static boolean answer;
	
	public static void main(String arg[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int c = Integer.parseInt(br.readLine());
		
		while(c-- > 0){
			size = Integer.parseInt(br.readLine());
			arr = new int[size][size];
			visited = new int[size][size];
			for(int i=0;i<size;i++){
				String tmp[] = br.readLine().split(" ");
				for(int j=0;j<size;j++){
					arr[i][j] = Integer.parseInt(tmp[j]);
				}
			}
			answer = jump(0,0);
			if(answer)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
	static boolean jump(int x,int y){
		if(x>=size || y>=size)
			return false;
		if(x==size-1 && y==size-1)
			return true;
		if(visited[x][y] != NOT_VISITED)
			return visited[x][y]==YES;
	
		visited[x][y] = jump(x+arr[x][y],y) || jump(x,y+arr[x][y]) ? YES:NO;
		
		return visited[x][y]==YES;
	}
}
