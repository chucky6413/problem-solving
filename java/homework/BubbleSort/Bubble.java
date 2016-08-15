//***************************
// 파일명: Bubble.java
// 작성자: 이준우
// 작성일: 2016/03/20
// 프로그램 설명: 파일에서 입력받은 단어들을 정렬하여 출력하는 프로그램 입니다. 최선의 경우를 고려합니다.
//***************************

import java.util.Scanner;
import java.io.*;

public class Bubble {
	public static void main(String arg[])throws IOException{
		int num,count=0;
		Scanner fs;
		String words[],temp;
		boolean sorted;
		
		System.out.println("hw3_1 : 이준우\n");
		fs=new Scanner(new File("hw3_1.txt"));
		num=Integer.parseInt(fs.next());
		words=new String[num];
		//정렬 전 출력
		System.out.print("정렬 전 : ");
		for(int i=0;i<num;i++){
			words[i]=fs.next();
			System.out.print(words[i]+" ");
		}
		System.out.println();
		
		//bublesort 로 정렬
		for(int last=num;last>1;last--){
			sorted=true;
			for(int i=0;i<last-1;i++){
				if(words[i].compareToIgnoreCase(words[i+1])>0){
					temp=words[i];
					words[i]=words[i+1];
					words[i+1]=temp;
					sorted=false;
					count++;
				}
			}
			if(sorted==true) break;
		}
		
		//정렬 후 출력
		System.out.print("정렬 후 : ");
		for(int i=0;i<num;i++){
			System.out.print(words[i]+" ");
		}
		System.out.println();
		System.out.println("단어 교환 횟수 : "+count);
	}
}
