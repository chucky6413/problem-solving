/*
 * @github https://github.com/chucky6413/Algorithm-study/tree/master/java/AOJ
 * @author chucky3
 * 
 * 코드가 깔끔하지는 않지만..
 */

import java.io.*;

public class TrianglePath {
	static int arr[][];
	static int maxSum[][];
	static int t; //size
	public static void main(String arg[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int c = Integer.parseInt(br.readLine());
		
		while(c-- > 0){
			t = Integer.parseInt(br.readLine());
			arr = new int[t][t];
			maxSum = new int[t][t];
			for(int i=0;i<t;i++){
				String temp[] = br.readLine().split(" ");
				for(int j=0;j<=i;j++){
					arr[i][j] = Integer.parseInt(temp[j]);
				}
			}
			
			maxSum[0][0] = arr[0][0];
			int max=0;
			for(int i=1;i<t;i++){
				for(int j=0;j<=i;j++){
					max = maxMove(i-1,j-1)+arr[i][j]>maxMove(i-1,j)+arr[i][j]?maxMove(i-1,j-1)+arr[i][j]:maxMove(i-1,j)+arr[i][j];
					if(maxSum[i][j]!=0){
						if(max>maxSum[i][j])
							maxSum[i][j]=max;
					}else{
						maxSum[i][j]=max;
					}
				}
			}
			for(int i=0;i<t;i++){
				if(maxSum[t-1][i]>max)
					max=maxSum[t-1][i];
			}
			System.out.println(max);
		}
		
	}
	static int maxMove(int x,int y){
		if(x<0 || y<0 || x>=t || y>=t)
			return 0;
		
		return maxSum[x][y];
	}
}
