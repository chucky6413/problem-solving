/*
 * 2017.03.26
 * ��Ʈ��ŷ
 *
 * @problem https://www.acmicpc.net/problem/1799
 * @github https://github.com/chucky6413
 * @author chucky3
 */
import java.util.*;
import java.util.Arrays;

public class Problem1799 {
	static int N,max,result=0;
	static int bis[][] = new int[11][11]; //����� �ִ���
	static int psb[][] = new int[11][11]; //��������
	public static void main(String arg[]){
		Scanner input = new Scanner(System.in);
		String temp[];
		N = input.nextInt();
		
		for(int i=1;i<=N;i++){
			for(int j=1;j<=N;j++){
				psb[i][j] = input.nextInt();
			}
		}
	
		solveBlack(1,1,0); //����ĭ �ذ�
		result+=max;
		max = 0; //�ʱ�ȭ
		solveWhite(1,2,0); //��ĭ �ذ�
		result+=max;
		
		System.out.println(result);
	}
	public static void solveBlack(int row,int col,int cnt){
		if(cnt>max) //�ִ�� ����
			max = cnt;
		//���� 1,1�� ����
		if(col>N){
			row+=1;
			if(row%2==0){ //¦�� ���� 2�� ���� ����
				col=2;
			}else{
				col=1;
			}
		}
		if(row>N){
			return;
		}
		if(psb[row][col]==1 && check(row,col)){ //�����ϰ� ����� �� �� �ִٸ�
			bis[row][col]=1;
			solveBlack(row,col+2,cnt+1);
		}
		bis[row][col]=0; //����� �� �ڸ��� �ȵ� ��.
		solveBlack(row,col+2,cnt);
	}
	public static void solveWhite(int row,int col,int cnt){
		if(cnt>max) //�ִ�� ����
			max = cnt;
		//ȭ��Ʈ�� 1,2�� ����
		if(col>N){
			row+=1;
			if(row%2==0){ //ȭ��Ʈ�� ¦������ 1�� ���� ����
				col=1;
			}else{
				col=2;
			}
		}
		if(row>N){
			return;
		}
		if(psb[row][col]==1 && check(row,col)){ //�����ϰ� ����� �� �� �ִٸ�
			bis[row][col]=1;
			solveWhite(row,col+2,cnt+1);
		}
		bis[row][col]=0; //����� �� �ڸ��� �ȵ� ��.
		solveWhite(row,col+2,cnt);
	}
	public static boolean check(int row,int col){ //���纸�� ���� ���� �밢���� ����� �ִ���.
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