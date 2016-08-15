//***************************
// 파일명: Select.java
// 작성자: 이준우
// 작성일: 2016/04/06
// 프로그램 설명: selection algorithm 을 이용하여 i번째 원소를 찾는 프로그램 입니다.
//***************************
import java.util.Scanner;
import java.io.*;

public class Select {
	public static void main(String arg[]) throws IOException{
		System.out.println("hw4_1 : 이준우\n");
		
		Scanner fs;
		Scanner input=new Scanner(System.in);
		fs=new Scanner(new File("hw4_1.txt"));
		int n=fs.nextInt();
		int a[]=new int[n];
		
		System.out.println(" 리스트");
		for(int i=0;i<n;i++){
			a[i]=fs.nextInt();
			System.out.printf("%3d ",a[i]);
			if((i+1)%10==0)
				System.out.println();
		}
		System.out.println();
		System.out.print("몇 번째로 작은 수를 찾으십니까? ");
		int i=input.nextInt();
		int answer=select(a,0,n-1,i);
		System.out.println("답 : "+answer);
	}
	public static int select(int a[],int p,int r,int i){
		if(p==r)
			return a[p];
		int q=partition(a,p,r);
		int k=q-p+1;
		
		if(i<k)
			return select(a,p,q-1,i);
		else if(i==k)
			return a[q];
		else
			return select(a,q+1,r,i-k);
	}
	public static int partition(int a[],int p,int r){
		int x=a[r];
		int i=p-1;
		int temp=0;
		
		for(int j=p;j<r;j++){
			if(a[j]<=x){
				temp=a[++i];
				a[i]=a[j];
				a[j]=temp;
			}
		}
		temp=a[++i];
		a[i]=a[r];
		a[r]=temp;
		
		return i;
	}
}
