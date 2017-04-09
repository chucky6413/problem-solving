/*
 * 2017.04.09
 * BFS
 * 
 * @problem https://www.acmicpc.net/problem/1012
 * @github https://github.com/chucky6413
 * @author chucky3
 */
import java.util.*;
import java.io.*;

public class Main{
	static int t,n,m,k,count=0;
	static final String NEWLINE = "\n";
	static boolean existed[][];
	static boolean visited[][];
	public static void main(String arg[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String temp[];
		t = Integer.parseInt(br.readLine());
		
		while(t-->0){
			count = 0; //카운트 초기화
			temp = br.readLine().split(" ");
			n = Integer.parseInt(temp[0]);
			m = Integer.parseInt(temp[1]);
			k = Integer.parseInt(temp[2]);
			
			existed = new boolean[n][m];
			visited = new boolean[n][m];
			
			while(k-->0){
				temp = br.readLine().split(" ");
				existed[Integer.parseInt(temp[0])][Integer.parseInt(temp[1])] = true;
			}
			
			for(int i=0;i<n;i++){
				for(int j=0;j<m;j++){
					if(!visited[i][j] && existed[i][j]){
						visited[i][j] = true;
						bfs(i,j);
						count++; //카운트 증가
					}
				}
			}
			sb.append(count+NEWLINE);
		}
		br.close();
		System.out.println(sb);
	}
	public static void bfs(int i, int j){
		Queue<Node> queue = new LinkedList<Node>();
		
		queue.offer(new Node(i,j));
		while(!queue.isEmpty()){
			Node node = queue.poll();
			int x = node.x;
			int y = node.y;
			int a,b;
			
			a=x-1;b=y;
			if(a>=0 && !visited[a][b] && existed[a][b]){
				visited[a][b] = true;
				queue.offer(new Node(a,b));
			}
			a=x;b=y+1;
			if(b<m && !visited[a][b] && existed[a][b]){
				visited[a][b] = true;
				queue.offer(new Node(a,b));
			}
			a=x+1;b=y;
			if(a<n && !visited[a][b] && existed[a][b]){
				visited[a][b] = true;
				queue.offer(new Node(a,b));
			}
			a=x;b=y-1;
			if(b>=0 && !visited[a][b] && existed[a][b]){
				visited[a][b] = true;
				queue.offer(new Node(a,b));
			}
		}
	}	
}
class Node{
	int x;
	int y;
	public Node(int x, int y){
		this.x = x;
		this.y = y;
	}
}