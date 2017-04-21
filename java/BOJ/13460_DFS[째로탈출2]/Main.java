/*
 * 2017.04.21
 * DFS
 * 
 * @problem https://www.acmicpc.net/problem/13460
 * @github https://github.com/chucky6413
 * @author chucky3
 */

import java.io.*;
import java.util.*;

public class Main {
	static int n,m,ans = -1;
	static int rx,ry,bx,by,gx,gy;
	static int tx1,ty1,tx2,ty2;
	static char arr[][];
	static boolean visit[][];
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	public static void main(String args[]) throws IOException{
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		m = input.nextInt();
		arr = new char[n][m];
		visit = new boolean[n][m];
		for(int i=0;i<n;i++){
			String s = input.next();
			for(int j=0;j<m;j++){
				arr[i][j] = s.charAt(j);
				if(arr[i][j]=='R'){
					rx = i;
					ry = j;
				}else if(arr[i][j]=='B'){
					bx = i;
					by = j;
				}else if(arr[i][j]=='O'){
					gx = i;
					gy = j;
				}
			}
		}
		dfs(rx,ry,bx,by,1);
		System.out.println(ans);
	}
	public static char[][] fill(char copy[][]){
		char origin[][] = new char[n][m];
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				origin[i][j] = copy[i][j];
			}
		}
		return origin;
	}
	public static void dfs(int x1,int y1,int x2,int y2,int cnt){
		if(cnt==11){
			return;
		}
		char[][] origin = new char[n][m];
		origin = fill(arr);
		for(int k=0;k<4;k++){
			
			//0 위 1 아래 2 왼 3 오른
			tx1 = x1 + dx[k];
			ty1 = y1 + dy[k];
			tx2 = x2 + dx[k];
			ty2 = y2 + dy[k];
			
			boolean r=false,b=false;
			
			switch(k){
			case 0:
				if(x1<x2){
					r=moveRed(x1,y1,k);
					b=moveBlue(x2,y2,k);
				}else{
					b=moveBlue(x2,y2,k);
					r=moveRed(x1,y1,k);
				}
				break;
			case 1:
				if(x1>x2){
					r=moveRed(x1,y1,k);
					b=moveBlue(x2,y2,k);
				}else{
					b=moveBlue(x2,y2,k);
					r=moveRed(x1,y1,k);
				}
				break;
			case 2:
				if(y1<y2){
					r=moveRed(x1,y1,k);
					b=moveBlue(x2,y2,k);
				}else{
					b=moveBlue(x2,y2,k);
					r=moveRed(x1,y1,k);
				}
				break;
			case 3:
				if(y1>y2){
					r=moveRed(x1,y1,k);
					b=moveBlue(x2,y2,k);
				}else{
					b=moveBlue(x2,y2,k);
					r=moveRed(x1,y1,k);
				}
			}
			
			if(b){
				arr=fill(origin);
				continue;
			}else if(r){
				if(ans==-1 || ans>cnt){
					ans=cnt;
				}
				arr=fill(origin);
				return;
			}
			
			dfs(tx1,ty1,tx2,ty2,cnt+1);
			arr = fill(origin);
		}
	}
	public static boolean moveRed(int x1,int y1,int k){
		while(arr[tx1][ty1]=='.'){
			tx1+=dx[k];
			ty1+=dy[k];
		}
		
		if(arr[tx1][ty1]=='O'){
			arr[x1][y1] = '.';
			return true;
		}else{
			tx1-=dx[k];
			ty1-=dy[k];
			arr[tx1][ty1] = 'R';
			if(x1!=tx1 || y1!=ty1)
				arr[x1][y1] = '.';
		}
		return false;
	}
	public static boolean moveBlue(int x2,int y2,int k){
		while(arr[tx2][ty2]=='.'){
			tx2+=dx[k];
			ty2+=dy[k];
		}
		
		if(arr[tx2][ty2]=='O'){
			arr[x2][y2] = '.';
			return true;
		}else{
			tx2-=dx[k];
			ty2-=dy[k];
			arr[tx2][ty2] = 'B';
			if(x2!=tx2 || y2!=ty2)
				arr[x2][y2] = '.';
		}
		
		return false;
	}
}
