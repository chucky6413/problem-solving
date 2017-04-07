/*
 * 2017.04.07
 * 링크드 리스트
 * 
 * @problem https://www.acmicpc.net/problem/1158
 * @github https://github.com/chucky6413
 * @author chucky3
 */
import java.util.*;

public class Main{
	static int n,m,index=0;
	static List<Integer> list;
	static final String NEWLINE = "\n";
	public static void main(String arg[]){
		Scanner input = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		n = input.nextInt();
		m = input.nextInt();
		
		list = new LinkedList<Integer>();
		for(int i=1;i<=n;i++){
			list.add(i);
		}
		sb.append("<");
		while(!list.isEmpty()){
			index = (index+m-1)%n;
			sb.append(list.get(index));
			list.remove(index);
			n--;
			if(n!=0) sb.append(", "); 
		}
		sb.append(">"+NEWLINE);
		System.out.println(sb);
	}
}