//***************************
// 파일명: Naive.java
// 작성자: 이준우
// 작성일: 2016.06.04
// 프로그램 설명:Naive 알고리즘을 이용한 문자열 매칭
//***************************
import java.util.Scanner;

public class Naive {
	public static void main(String arg[]){
		System.out.println("hw10_1 : 이준우\n");
		
		Scanner input = new Scanner(System.in);
		String line;
		char[] text,pattern;
		
		System.out.print("텍스트:");
		line=input.next();
		text = line.toCharArray();
		
		System.out.print("패턴:");
		line=input.next();
		pattern = line.toCharArray();
		
		naiveMatching(text,pattern); //함수 호출
		
	}
	public static void naiveMatching(char[] text,char[] pattern){
		int n=text.length;
		int m=pattern.length;
		int count=0;
		System.out.print("매칭 위치:");
		//이중 for문 평균 O(mn)
		for(int i=0;i<n-m+1;i++){ //O(n)
			int k=i;
			for(int j=0;j<m;j++){ //O(m)
				if(text[k]==pattern[j])
					k++;
				else
					break;
			}
			if(k==(i+m)){
				System.out.print(i+" ");
				count++;
			}
		}
		if(count==0)
			System.out.println("매칭이 일어나지 않음.");
	}
}
