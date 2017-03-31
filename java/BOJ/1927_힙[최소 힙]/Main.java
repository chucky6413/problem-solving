/*
 * 2017.03.31
 * ÃÖ¼Ò Èü
 * 
 * @problem https://www.acmicpc.net/problem/1927
 * @github https://github.com/chucky6413
 * @author chucky3
 */
import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static final String NEWLINE = "\n";
	public static void main(String arg[]) throws IOException{
		Scanner input = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		n = input.nextInt();
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		for(int i=0;i<n;i++){
			int num = input.nextInt();
			if(num==0){
				if(queue.isEmpty()) sb.append("0"+NEWLINE);
				else sb.append(queue.poll()+NEWLINE);
			}else{
				queue.offer(num);
			}
		}
		System.out.println(sb);
	}
}