/*
 * 2017.04.18
 * DFS
 *
 * @problem https://www.acmicpc.net/problem/14500
 * @github https://github.com/chucky6413
 * @author chucky3
 */
import java.util.*;
import java.io.*;

public class Main{
	static int n,m;
	static int max=0;
	static int arr[][];
	static boolean visit[][];
	static int dx[] = {0,1,0,-1};
	static int dy[] = {1,0,-1,0};
	static int sdx[][] = {{0,-1,1},{-2,-1,-1},{0,-1,1},{2,1,1}};
	static int sdy[][] = {{-2,-1,-1},{0,-1,1},{2,1,1},{0,1,-1}};
	public static void main(String arg[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp[];
		
		temp = br.readLine().split(" ");
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);
		arr = new int[n][m];
		visit = new boolean[n][m];
		for(int i=0;i<n;i++){
			temp = br.readLine().split(" ");
			for(int j=0;j<m;j++){
				arr[i][j] = Integer.parseInt(temp[j]);
			}
		}
		br.close();		
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				for(int k=0;k<4;k++)
					dfs(i,j,1,arr[i][j],k);
			}
		}
		System.out.println(max);
	}
	public static void dfs(int x,int y,int cnt,int score,int dir){
		if(visit[x][y]){
			return;
		}else{
			visit[x][y] = true;
		}
		
		if(cnt==4){
			if(score>max)
				max=score;
			visit[x][y] = false;
			return;
		}
		
		int tx,ty,tDir;
		
		for(int k=0;k<4;k++){
			tDir = (dir+k)%4;
			tx = x+dx[tDir];
			ty = y+dy[tDir];
			if(inner(tx,ty) && Math.abs(tDir-dir)!=2)
				dfs(tx,ty,cnt+1,score+arr[tx][ty],tDir);
		}
		
		if(cnt==3){
			for(int k=0;k<3;k++){
				tx = x+sdx[dir][k];
				ty = y+sdy[dir][k];
				if(inner(tx,ty))
					dfs(tx,ty,cnt+1,score+arr[tx][ty],dir);
			}
		}
		
		visit[x][y] = false;
	}
	public static boolean inner(int x,int y){
		if(x<0 || x>n-1 || y<0 || y>m-1 || visit[x][y]){
			return false;
		}
		return true;
	}
}