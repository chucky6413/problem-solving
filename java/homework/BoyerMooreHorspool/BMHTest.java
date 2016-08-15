//***************************
// 파일명: BMHTest.java
// 작성자: 이준우
// 작성일: 2016.06.04
// 프로그램 설명:보이어-무어-호스풀 알고리즘을 이용한 문자열 매칭
//***************************
import java.util.Scanner;
import java.util.HashMap;

public class BMHTest {
	public static void main(String arg[]){
		System.out.println("hw10_2 : 이준우\n");
		
		Scanner input = new Scanner(System.in);
		String line;
		char[] text,pattern;
		
		System.out.print("텍스트:");
		line=input.next();
		text = line.toCharArray();
		
		System.out.print("패턴:");
		line=input.next();
		pattern = line.toCharArray();
		
		BoyerMooreHorspool(text,pattern); //함수 호출
	
		
	}
	public static void BoyerMooreHorspool(char[] text,char[] pattern){
		int n=text.length;
		int m=pattern.length; //패턴의 길이 jump의 기타 값
		HashMap<Character,Integer> jump = new HashMap<Character,Integer>();
		
		computeJump(pattern,jump); //전처리 : 수행시간 O(m)
		int i=0,j,k,count=0;
		System.out.print("매칭 위치:");
		while(i<n-m+1){
			j=m-1;
			k=i+m-1;
			while(j>=0 && pattern[j]==text[k]){
				j--;
				k--;
			}
			if(j==-1){
				System.out.print((k+1)+" ");
				count++;
			}
			if(jump.get(text[i+m-1])!=null)
				i=i+jump.get(text[i+m-1]);
			else
				i=i+m;
		}
		if(count==0)
			System.out.println("매칭이 일어나지 않음.");
		
	}
	public static void computeJump(char[] pattern,HashMap jump){
		int m=pattern.length;
		System.out.println(m);
		for(int i=1;i<m;i++){
			if(jump.get(pattern[m-i-1])==null) //같은 문자일 경우 작은것으로 저장하기 때문에
				jump.put(pattern[m-i-1],i);  //작은 수부터 저장을 시작한다. pattern의 뒤에서 2번째 자리부터
		}
		if(jump.get(pattern[m-1])==null) //같은 것이 없을 경우
			jump.put(pattern[m-1],m);  //패턴의 마지막 자리수는 pattern의 길이인 m이다.
	}
}
