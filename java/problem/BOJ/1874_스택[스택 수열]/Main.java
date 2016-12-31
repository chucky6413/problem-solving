/*
 * 2016.11.5
 * 스택 수열.
 */
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String arg[]){
		Scanner input = new Scanner(System.in);
		
		int N = input.nextInt(); //사이즈 입력
		
		Stack<Integer> stack = new Stack<Integer>();
		StringBuilder sb = new StringBuilder(); //+,- 결과 저장할 변수
		int seq[] = new int[N]; //입력될 수열 저장할 변수
		
		for(int i=0;i<N;i++){
			seq[i] = input.nextInt(); 
		}
		
		int number = 1; //1~N 숫자
		int pointer = 0; //수열의 비교할 index
		
		while(pointer!=N && number!=N+2){ //number가 N+1일 경우 나머지 작업은 모두 pop이어야 함.
			if(!stack.isEmpty()){
				if(stack.peek() == seq[pointer]){
					stack.pop();
					pointer++;
					sb.append("-\n");
				}else{
					stack.push(number);
					number++;
					sb.append("+\n");
				}
			}else{
				stack.push(number);
				number++;
				sb.append("+\n");
			}
		}
		if(pointer==N)
			System.out.println(sb.toString()); //출력
		else
			System.out.println("NO");
	}
}
