//******************************************************
 // 파일명: hw11_1.java
 // 작성자: 이준우
 // 작성일: 2015.11.29
 // 내용:  단어정렬 시키는 삽입정렬
 //******************************************************

import java.util.*;

class Sort{
	public static void insertionSort(String a[],int size){
		int i,j;
		String item;
		for(i=1;i<size;i++){
			item=a[i];
			j=i;
			while((j>0)&&((a[j-1].compareToIgnoreCase(item)>0))){
				a[j]=a[j-1];
				j--;
			}
			a[j]=item;
		}
	}
}
public class InsertionSort {
	@SuppressWarnings("static-access")
	public static void main(String arg[]){
		System.out.println("hw11_1:이준우\n");
		Scanner input=new Scanner(System.in);
		int num;
		Sort s1=new Sort();
		
		System.out.print("단어 수 입력 : ");
		num=input.nextInt();
		input.nextLine();
		String s[] = new String[num];
			
		System.out.println(num+"개의 단어 입력 : ");
		for(int i=0;i<num;i++){
			s[i]=input.nextLine();
		}
		
		s1.insertionSort(s, num);

		System.out.println("\n사전 순 출력 : ");
		for(int i=0;i<num;i++){
			System.out.println(s[i]);
		}
	}
}
