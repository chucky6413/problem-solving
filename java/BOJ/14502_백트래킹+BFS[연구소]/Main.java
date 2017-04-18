/*
 * 2017.04.18
 * 백트래킹 , BFS
 *
 * @problem https://www.acmicpc.net/problem/14502
 * @github https://github.com/chucky6413
 * @author chucky3
 */
import java.util.*;
import java.io.*;

public class Main{
	static int n,m;
	static int arr[][];
	static int dx[] = {1,0,-1,0};
	static int dy[] = {0,1,0,-1};
	static List<Birus> birus = new LinkedList<Birus>();
	static int wall = 0;
	static int max = 0;
	public static void main(String arg[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp[];
		
		temp = br.readLine().split(" ");
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);
		arr = new int[n][m];

		for(int i=0;i<n;i++){
			temp = br.readLine().split(" ");
			for(int j=0;j<m;j++){
				arr[i][j] = Integer.parseInt(temp[j]);
				if(arr[i][j]==1){
					wall+=1;
				}else if(arr[i][j]==2){
					birus.add(new Birus(i,j));
				}
			}
		}
		
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(arr[i][j]==0)
					search(i,j,1);
			}
		}
		System.out.println(max);
	}
	public static void search(int x,int y,int cnt){ //벽 설치
		arr[x][y] = 1;
		if(cnt==3){
			int birusCnt = birus();
			if((n*m)-(cnt+birusCnt+wall)>max){
				max = (n*m)-(cnt+birusCnt+wall);
			}
			arr[x][y] = 0;
			return;
		}
		
		for(int i=x;i<n;i++){
			for(int j=0;j<m;j++){
				if(arr[i][j]==0)
					search(i,j,cnt+1);
			}
		}
		
		arr[x][y] = 0; //복구.
	}
	public static int birus(){
		Queue<Birus> queue = new LinkedList<Birus>();
		int size = birus.size();
		for(int i=0;i<size;i++){
			queue.offer(birus.get(i));
		}
		
		int tempArr[][] = new int[n][m];
		
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				tempArr[i][j] = arr[i][j];
			}
		}
		
		while(!queue.isEmpty()){
			Birus b = queue.poll();
			int tx,ty;
			
			for(int k=0;k<4;k++){
				tx = b.x + dx[k];
				ty = b.y + dy[k];
				if(inner(tx,ty) && tempArr[tx][ty]==0){
					tempArr[tx][ty] = 2;
					queue.offer(new Birus(tx,ty));
					size++;
				}
			}	
		}
		
		return size;
	}
	public static boolean inner(int x,int y){
		if(x<0 || x>n-1 || y<0 || y>m-1){
			return false;
		}
		return true;
	}
}
class Birus{
	int x;
	int y;
	public Birus(int x,int y){
		this.x = x;
		this.y = y;
	}
}