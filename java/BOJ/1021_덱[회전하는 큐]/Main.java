/*
 * 2017.04.09
 * DEQUE
 * 
 * @problem https://www.acmicpc.net/problem/1021
 * @github https://github.com/chucky6413
 * @author chucky3
 */
import java.util.*;
import java.io.*;

public class Main{
	static int n,m,count=0;
	static int question[];
	public static void main(String arg[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp[];
		
		temp = br.readLine().split(" ");
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);
		question = new int[m];
		temp = br.readLine().split(" ");
		for(int i=0;i<m;i++){
			question[i] = Integer.parseInt(temp[i]);
		}
		br.close();
		
		ArrayDeque<Integer> rotateLeft = new ArrayDeque<Integer>();
		ArrayDeque<Integer> rotateRight = new ArrayDeque<Integer>();
		
		for(int i=1;i<=n;i++){
			rotateLeft.offer(i);
			rotateRight.offer(i);
		}
		
		for(int item : question){
			int size = rotateLeft.size();
			for(int i=0;i<size;i++){
				//왼쪽
				int leftItem = rotateLeft.pollFirst(); //1번 연산.
				
				//같다면
				if(leftItem == item){
					count+=i; //2번 연산 횟수 +1을 안해주는 이유 -> 아직 1번 연산 밖에 안했다.
					rotateRight = rotateLeft.clone(); //상태 일치 시킴.
					break;
				}
				
				int rightItem = rotateRight.pollLast();
				
				if(rightItem == item){
					count+=i + 1; //3번 오른쪽 연산 횟수
					rotateLeft = rotateRight.clone();
					break;
				}
				
				//둘다 아니면.
				rotateLeft.offerLast(leftItem);
				rotateRight.offerFirst(rightItem);
			}
		}
		System.out.println(count);
	}
}