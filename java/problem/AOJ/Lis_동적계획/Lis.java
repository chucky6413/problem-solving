/*
 * 최대 증가 부분 수열
 * 재귀 호출로 동적 프로그래밍 잘 짰는데..
 * 계속 오답 처리가 됬다..
 * 이유 : algospot 은 입력 중간에 답을 출력하면 틀림.. 마지막에 한번에 답을 출력해줘야 success..
 */
import java.io.*;

public class Lis {
	
	static int arr[];
	static int max[];
	static int size;
	static int result[];
	
	public static void main(String arg[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int C = Integer.parseInt(br.readLine());
		result = new int[C];
		for(int c=0;c<C;c++){
			size = Integer.parseInt(br.readLine());
			arr = new int[size];
			max = new int[size];
			String[] temp = br.readLine().split(" ");
			for(int i=0;i<size;i++){
				arr[i] = Integer.parseInt(temp[i]);
			}
			for(int i=0;i<size;i++){
				int value = lis(i);
				if(value>result[c])
					result[c] = value;
			}
		}
		for(int print:result){
			System.out.println(print);
		}
	}
	static int lis(int index){
		if(max[index]>0)
			return max[index];
		
		int maxValue = 1;
		int temp = 0;
		
		for(int i=index;i<arr.length;i++){
			if(arr[i]>arr[index]){
				temp=lis(i)+1;
				if(temp>maxValue)
					maxValue=temp;
			}
		}
		
		max[index] = maxValue;
		
		return max[index];
	}
}
