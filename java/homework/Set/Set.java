//***************************
// 파일명: Set.java
// 작성자: 이준우
// 작성일: 2016/03/16
// 프로그램 설명: 두 집합을 매개변수로 받아 집합의 내용을 출력하고 동일한지 검사하는 프로그램입니다.
//***************************

public class Set {
	public static void main(String arg[]){
		int set1[]={1,5,8,3,2,9};
		int set2[]={2,1,9,5,3,8};
		
		int set3[]={2,6,8,1};
		int set4[]={8,6,2,7};
		
		int set5[]={1,2,3,4,5};
		int set6[]={1,2,0,7,5};
		
		int set7[]={1,2,3,4,5,6,7};
		int set8[]={1,2,3,4,5,6};
		
		int set9[]={};
		int set10[]={};
		
		System.out.println("hw0_1 : 이준우\n");
		compare(set1,set2);
		compare(set3,set4);
		compare(set5,set6);
		compare(set7,set8);
		compare(set9,set10);
	}
	public static boolean compare(int set1[],int set2[]){
		if(set1.length!=0 && set2.length!=0){
			System.out.print("set1 = {");
			for(int i=0;i<set1.length-1;i++)
				System.out.print(set1[i]+",");
			System.out.println(set1[set1.length-1]+"}");
		
			System.out.print("set2 = {");
			for(int i=0;i<set2.length-1;i++)
				System.out.print(set2[i]+",");
			System.out.println(set2[set2.length-1]+"}");
		}else{
			System.out.println("set1 = {}");
			System.out.println("set2 = {}");
		}
		
		for(int i=0;i<set1.length;i++){
			for(int j=0;j<set2.length;j++){
				if(set1[i]==set2[j])
					break;
				if(j==set2.length-1 && set1[i]!=set2[j]){
					System.out.println("위의 두 집합은 동일하지 않습니다.\n");
					return false;
				}
			}
		}
			
		System.out.println("위의 두 집합은 동일합니다.\n");
		return true;
	}
}
