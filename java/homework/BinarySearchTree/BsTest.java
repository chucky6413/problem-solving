//****************************************************************
// 파일명: BsTest.java
// 작성자:이준우
// 작성일:2016-05-13
// 내용: 이진검색트리를 이용하여 검색과 삽입기능 등을 실행하는 프로그램
//****************************************************************
import java.util.Scanner;

public class BsTest {
	public static void main(String arg[]){
		System.out.println("hw5_1 : 이준우\n");
		Scanner input = new Scanner(System.in);
		
		BinarySearchTree tree = new BinarySearchTree();
		int sel=0;
		int id=0;
		
		while(true){
			System.out.println("1.회원가입 2.포인트조회 3.포인트적립 4.전체조회 5.회원수조회 6.회원탈퇴 7.종료");
			System.out.print("입력 : ");
			sel=input.nextInt();
			if(sel==7){
				System.out.println("종료합니다.");
				break;
			}
			switch(sel){
				case 1:
					System.out.println("1.회원가입");
					System.out.print("가입할 id 입력 : ");
					id=input.nextInt();
					if(tree.add(id))
						System.out.println("성공\n");
					else
						System.out.println("실패\n");
					break;
				case 2:
					System.out.println("2.포인트조회");
					System.out.print("id 입력 : ");
					id=input.nextInt();
					if(tree.get(id)==-1)
						System.out.println("실패\n");
					else
						System.out.println("포인트 : "+tree.get(id)+"\n");
					break;
				case 3:
					System.out.println("3.포인트적립");
					System.out.print("id 입력 : ");
					id=input.nextInt();
					System.out.print("적립할 포인트 : ");
					int point=input.nextInt();
					if(tree.set(id,point))
						System.out.println("성공\n");
					else
						System.out.println("실패\n");
					break;
				case 4:
					System.out.println("4.전체조회");
					tree.print();
					break;
				case 5:
					System.out.println("5.회원수조회");
					System.out.println(tree.size()+"\n");
					break;
				case 6:
					System.out.println("6.회원탈퇴");
					System.out.println("구현하지 않음\n");
					break;
			}
		}
	}
}
	