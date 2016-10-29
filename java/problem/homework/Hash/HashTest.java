//****************************************************************
// 파일명: HashTest.java
// 작성자:이준우
// 작성일:2016-05-09
// 내용: 해쉬테이블을 이용하여 삽입,검색,삭제,조회 기능 등을 실행하는 프로그램
//****************************************************************

import java.util.Scanner;

public class HashTest {
	public static void main(String arg[]){
		System.out.println("hw6_1 : 이준우\n");
		int size;
		Scanner input = new Scanner(System.in);
		System.out.print("테이블 크기 입력:");
		size=input.nextInt();
		Hash hash = new Hash(size);
		int sel=0;
		int x;
		while(sel!=5){
			System.out.println("1:삽입 2:검색 3:삭제 4:전체출력 5:종료");
			System.out.print("선택:");
			sel=input.nextInt();
			switch(sel){
			case 1:
				System.out.print("삽입할 학번:");
				x=input.nextInt();
				hash.insert(x);
				break;
			case 2:
				System.out.print("검색할 학번:");
				x=input.nextInt();
				hash.search(x);
				break;
			case 3:
				System.out.print("삭제할 학번:");
				x=input.nextInt();
				hash.delete(x);
				break;
			case 4:
				hash.print();
				break;
			case 5:
				System.out.println("종료합니다.");
				break;
			}
		}
		
	}
}
