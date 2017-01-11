/*
 * 2016.12.12
 * µ¿Àû °èÈ¹¹ý
 *
 * @problem https://www.acmicpc.net/problem/1149
 * @author chucky3
 *
 * cost[n][m]=min(cost[n-1][(j+1)%3],cost[n-1][(j+2)%3])+arr[m] ..
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int cost[][];
	static String arr[];
	static int n;
	public static void main(String arg[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		
		cost = new int[n+1][3];
		for(int i=1;i<=n;i++){
			arr = br.readLine().split(" ");
			for(int j=0;j<3;j++){
				cost[i][j]=Math.min(cost[i-1][(j+1)%3],cost[i-1][(j+2)%3])+Integer.parseInt(arr[j]);
			}
		}
		int min=Integer.MAX_VALUE;
		for(int j=0;j<3;j++){
			if(cost[n][j]<min){
				min=cost[n][j];
			}
		}
		System.out.println(min);
	}
}
