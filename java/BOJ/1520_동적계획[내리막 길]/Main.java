/*
 * 2017.04.14
 * 동적계획
 * 
 * @problem https://www.acmicpc.net/problem/1520
 * @github https://github.com/chucky6413
 * @author chucky3
 */
import java.util.*;
import java.io.*;

public class Main{
	static int n,m;
	static final int DX[] = {-1,1,0,0}; //아래 , 위 , 왼쪽 ,오른쪽
	static final int DY[] = {0,0,-1,1};
	static int arr[][],dp[][];
	public static void main(String arg[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp[];
		
		temp = br.readLine().split(" ");
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);
		arr = new int[n][m];
		dp = new int[n][m];
		
		for(int i=0;i<n;i++){
			temp = br.readLine().split(" ");
			for(int j=0;j<m;j++){
				arr[i][j] = Integer.parseInt(temp[j]);
			}
			Arrays.fill(dp[i], -1); //-1로 채워 놓는다.
		}
		
		solve(n-1,m-1);
		System.out.println(dp[n-1][m-1]);
	}
	public static int solve(int x,int y){
		if(x==0 && y==0){ //기저 사례 
			dp[x][y] = 1;
		}
		
		if(dp[x][y]==-1){
			dp[x][y] = 0; //0으로 초기화.
			for(int k=0;k<4;k++){
				int tempX = x+DX[k];
				int tempY = y+DY[k];
				if((tempX>=0 && tempY>=0) && (tempX<n && tempY<m) && arr[tempX][tempY] > arr[x][y])
					dp[x][y] += solve(tempX,tempY);
			}
		}
		
		return dp[x][y];
	}
}