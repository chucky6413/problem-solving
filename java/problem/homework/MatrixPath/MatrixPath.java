//****************************************************************
//파일명: MatrixPath.java
//작성자:이준우
//작성일: 2016-5-25
//내용: 행렬경로문제(최고 점수) 프로그램
//****************************************************************

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MatrixPath {
	public static void main(String arg[]) throws IOException{
		System.out.println("hw8_1 : 이준우\n");
		Scanner input = new Scanner(new File("hw8_1.txt"));
		
		int n = input.nextInt();
		int m[][] = new int[n][n];
		
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
				m[i][j] = input.nextInt();
		
		maxMatrixPath(n,m);
		
	}
	public static void maxMatrixPath(int n,int m[][]){
		int c[][]=new int[n][n];
		c[0][0]=m[0][0];
		
		for(int i=1;i<n;i++)
			c[i][0]=m[i][0]+c[i-1][0];
		for(int j=1;j<n;j++)
			c[0][j]=m[0][j]+c[0][j-1];
		for(int i=1;i<n;i++)
			for(int j=1;j<n;j++){
				int max=0;
				if(c[i-1][j]>c[i][j-1]){
					max=c[i-1][j];
				}else{
					max=c[i][j-1];
				}
				c[i][j]=m[i][j]+max;
			}
		//최고점 출력
		System.out.println("최고점 : "+c[n-1][n-1]);
		
		//경로 출력
		String path[] = new String[(n*2)-1];
		int i=n-1,j=n-1,k=0;
		while(i!=1 || j!=1){
			path[k]=" -> ("+i+","+j+")";
			k++;
			if((i==1 && j==0)||(i==0&&j==1))
				break;
			if(i==0)
				j--;
			else if(j==0)
				i--;
			else if(c[i][j-1]>c[i-1][j])
				j--;
			else
				i--;
		}
		path[k]="(0,0)";
		for(i=k;i>=0;i--)
			System.out.print(path[i]);
		
	}
}


