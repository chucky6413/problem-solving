//***************************
 // 파일명: hw7_2.java
 // 작성자: 이준우
 // 작성일: 2015.10.16
 // 내용: 후위표기식을 계산하는 프로그램 예외처리는 메인에서 할 수 있도록 던져주는 방식이다.
 //***************************


import java.util.Scanner;
import java.util.StringTokenizer;

class FailOptException extends Exception{ // 잘못된 수식 예외클래스 생성.
	public FailOptException(){
		super("잘못된 수식입니다.");
	}
}
class ArithmeticException extends Exception{ // 잘못된 수식 예외클래스 생성.
	public ArithmeticException(){
		super("0으로는 나눌 수 없습니다. 종료합니다.");
	}
}

interface Stack{
	boolean isEmpty();
	boolean isFull();
	int pop();
	void push(int item);
}

class IntegerStack implements Stack{ //정수형을 저장하는 Stack클래스
	private int ArrayItem[];
	private int top=-1;
	private int stackSize=100;
	
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

class OptExp{
	private String exp;
	
	public int evalPostfix(String s) throws FailOptException,ArithmeticException{  //예외처리는 메인함수에서 하도록 던저 주었다.
		IntegerStack S=new IntegerStack();
		exp=s;
		char testCh;
		int opr1,opr2,result=0;
		int size;
		
		StringTokenizer st=new StringTokenizer(exp," ");
		size=st.countTokens();
		for(int i=0;i<size;i++){
			exp=st.nextToken();
			
			if(exp.equals("+")||exp.equals("-")||exp.equals("*")||exp.equals("/")){
				testCh=exp.charAt(0);
				switch(testCh){
				case '+': opr2=S.pop(); opr1=S.pop();S.push(opr1+opr2);break;
				case '-': opr2=S.pop(); opr1=S.pop();S.push(opr1-opr2);break;
				case '*': opr2=S.pop(); opr1=S.pop();S.push(opr1*opr2);break;
				case '/': opr2=S.pop(); opr1=S.pop();
				if(opr2==0)
					throw new ArithmeticException();
				else
					S.push(opr1/opr2);break;
				}
			}
			else{
				S.push(Integer.parseInt(exp));
			}		
		}
		
		result = S.pop();
		if(S.isEmpty()) //예외처리는 메인에서 해주도록 던저 주었다.
			return result;
		else
			throw new FailOptException();
	}
}

public class hw7_2 {
	public static void main(String arg[]) {
		System.out.println("hw7_2:이준우\n");
		String s;
		Scanner input=new Scanner(System.in);
		
		System.out.println("정수 후위 수식 입력");
		s=input.nextLine();
		try{ //예외처리를 main 에서 해준다.
		OptExp op = new OptExp();
		System.out.println("계산 결과 = "+op.evalPostfix(s));
		}catch(FailOptException e){
			System.err.println(e.getMessage());
		}catch(ArithmeticException e){
			System.err.println(e.getMessage());
		}catch(NumberFormatException e){ // .같은 이상한 수식도 잡아준다.
			System.err.println("잘못된 수식입니다.");
		}
	}
}
