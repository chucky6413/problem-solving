/*
 * 2017.03.26
 * 백트래킹
 *
 * @problem https://www.acmicpc.net/problem/1799
 * @github https://github.com/chucky6413
 * @author chucky3
 */
import java.util.*;
import java.util.Arrays;

public class Main {
	static int N,max,result=0;
	static int bis[][] = new int[11][11]; //비숍이 있는지
	static int psb[][] = new int[11][11]; //가능한지
	public static void main(String arg[]){
		Scanner input = new Scanner(System.in);
		String temp[];
		N = input.nextInt();
		
		for(int i=1;i<=N;i++){
			for(int j=1;j<=N;j++){
				psb[i][j] = input.nextInt();
			}
		}
	
		solveBlack(1,1,0); //검정칸 해결
		result+=max;
		max = 0; //초기화
		solveWhite(1,2,0); //흰칸 해결
		result+=max;
		
		System.out.println(result);
	}
	public static void solveBlack(int row,int col,int cnt){
		if(cnt>max) //최대면 갱신
			max = cnt;
		//블랙을 1,1로 가정
		if(col>N){
			row+=1;
			if(row%2==0){ //짝수 행은 2열 부터 시작
				col=2;
			}else{
				col=1;
			}
		}
		if(row>N){
			return;
		}
		if(psb[row][col]==1 && check(row,col)){ //가능하고 비숍을 둘 수 있다면
			bis[row][col]=1;
			solveBlack(row,col+2,cnt+1);
		}
		bis[row][col]=0; //비숍을 이 자리에 안둘 때.
		solveBlack(row,col+2,cnt);
	}
	public static void solveWhite(int row,int col,int cnt){
		if(cnt>max) //최대면 갱신
			max = cnt;
		//화이트를 1,2로 가정
		if(col>N){
			row+=1;
			if(row%2==0){ //화이트의 짝수행은 1열 부터 시작
				col=1;
			}else{
				col=2;
			}
		}
		if(row>N){
			return;
		}
		if(psb[row][col]==1 && check(row,col)){ //가능하고 비숍을 둘 수 있다면
			bis[row][col]=1;
			solveWhite(row,col+2,cnt+1);
		}
		bis[row][col]=0; //비숍을 이 자리에 안둘 때.
		solveWhite(row,col+2,cnt);
	}
	public static boolean check(int row,int col){ //현재보다 이전 행의 대각선에 비숍이 있는지.
		for(int i=1;i<row;i++){
			for(int j=1;j<=N;j++){
				if(bis[i][j]==1 && row-i == Math.abs(col-j)){
					return false;
				}
			}
		}
		return true;
	}
}