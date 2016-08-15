//***************************
// 파일명: CountingSort.java
// 작성자: 이준우
// 작성일: 2016/04/02
// 프로그램 설명: counting sort 를 이용하여 정렬하는 프로그램 입니다.
//***************************

import java.util.Scanner;
import java.io.*;

public class CountingSort {
	public static void main(String arg[]) throws FileNotFoundException{
		int n;
		Scanner fs;
		System.out.println("hw3_6 : 이준우\n");
		fs=new Scanner(new File("hw3_6.txt"));
		
		n=fs.nextInt();
		int a[]=new int[n];
		int b[]=new int[n];
		
		System.out.println("정렬 전");
		for(int i=0;i<n;i++){
			a[i]=fs.nextInt();
			System.out.printf("%3d ",a[i]);
			if((i+1)%10==0)
				System.out.println();
		}
		System.out.println();
		
		countingSort(a,b,n);
		
		System.out.println("정렬 후");
		for(int i=0;i<n;i++){
			System.out.printf("%3d ",b[i]);
			if((i+1)%10==0)
				System.out.println();
		}
		System.out.println();
		
	}
	public static void countingSort(int []a,int []b,int n){
		int c[]=new int[21];
		for(int i=0;i<21;i++)
			c[i]=0;
		for(int j=0;j<n;j++)
			c[a[j]+10]++;
		for(int i=1;i<21;i++)
			c[i]=c[i]+c[i-1];
		for(int j=n-1;j>=0;j--){
			b[c[a[j]+10]-1]=a[j];
			c[a[j]+10]--;
		}
	}
}
