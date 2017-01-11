/*
 * 2016.12.04
 * Å½¿å¹ý
 *
 * @problem https://www.acmicpc.net/problem/1931
 * @author chucky3
 */
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String arg[]){
		Scanner sc = new Scanner(System.in);
		int count=0;
		int n = sc.nextInt();
		PriorityQueue<Meeting> q = new PriorityQueue();

		while( n-- > 0){
			int start = sc.nextInt();
			int end = sc.nextInt();
			q.offer(new Meeting(start,end));
		}

		int lastEnd = -1;
		while(!q.isEmpty()){
			Meeting m = q.poll();
			if(m.start>=lastEnd){
				lastEnd=m.end;
				count++;
			}
		}
		System.out.println(count);
	}
}
class Meeting implements Comparable<Meeting>{
	int start;
	int end;
	
	public Meeting(int start,int end){
		this.start = start;
		this.end = end;
	}
	public int compareTo(Meeting m){
		if(end==m.end){
			return start-m.start;
		}
		return end-m.end;
	}
}