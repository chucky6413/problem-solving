//***************************
 // 파일명: hw7_1.java
 // 작성자: 이준우
 // 작성일: 2015.10.16
 // 설명: 정수 스택의 구현
//***************************
interface Stack{
	boolean isEmpty();
	boolean isFull();
	int pop();
	void push(int item);
}
class IntegerStack implements Stack{ //정수형을 저장하는 Stack클래스
	private int ArrayItem[];
	private int top=-1;
	private int stackSize=5;
	
	public IntegerStack(){ //생성자
		ArrayItem=new int[stackSize];
	}
	
	public boolean isEmpty(){
		return (top==-1);
	}
	public boolean isFull(){
		return (top==this.stackSize-1);
	}
	public int pop(){
		if(isEmpty()){
			System.out.println("스택이 비어있습니다.");
			return 0;
		}
		else
			return ArrayItem[top--];
	}
	public void push(int item){
		if(isFull())
			System.out.println("스택이 꽉차있습니다.");
		else
			ArrayItem[++top]=item;
	}
	
	
}

public class hw7_1 {
	public static void main(String arg[]){
		
		IntegerStack stack1=new IntegerStack(); //객체 생성
		int deleteItem; //삭제한 항목
		int delSum=0; //삭제한 합
		
		System.out.println("hw7_1:이준우\n");
		
		stack1.push(-1);
		stack1.push(0);
		stack1.push(1);
		stack1.push(2);
		stack1.push(3);
		stack1.push(4);
		
		System.out.println();
		deleteItem=stack1.pop();
		System.out.print(deleteItem+" ");
		deleteItem=stack1.pop();
		System.out.print(deleteItem+" ");
		deleteItem=stack1.pop();
		System.out.print(deleteItem+" ");
		deleteItem=stack1.pop();
		System.out.print(deleteItem+" ");
		deleteItem=stack1.pop();
		System.out.print(deleteItem+" ");
		
		System.out.println();
		stack1.push(10);
		stack1.push(30);
		stack1.push(50);
		deleteItem=stack1.pop();
		System.out.println(deleteItem+" ");
		stack1.push(70);
		
		delSum+=stack1.pop();
		delSum+=stack1.pop();
		delSum+=stack1.pop();
		
		System.out.println("삭제한 값의 합:"+delSum);
	}
}
