/*
 * 2017.03.20
 * JAVA로 시간초과 안나는 코드
 *
 * @problem https://www.acmicpc.net/problem/12430
 * @github https://github.com/chucky6413
 * @author chucky3
 */
import java.util.*;
import java.io.*;

public class Main {
	static List<Node> list = new ArrayList<Node>();
	static boolean d[] = new boolean[101001];
	static int answer;
	public static void main(String arg[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		String temp[];
		int test = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=test;t++){
			int max = 0;
			int n = Integer.parseInt(br.readLine());
			list.clear();
			for(int i=0;i<n;i++){
				temp = br.readLine().split(" ");
				int si = Integer.parseInt(temp[0]);
				int pi = Integer.parseInt(temp[1]);
				list.add(new Node(si,pi));
			}
			Collections.sort(list);
			max = list.get(n-1).p + list.get(n-1).s;
			answer = 0;
			Arrays.fill(d, false);
			d[0] = true;
			for(int i=0;i<n;i++){
				for(int j=list.get(i).p;j>=0;j--){
					if(d[j]){
						d[j+list.get(i).s] = true;
					}
				}
			}
			for(int i=max;i>=0;i--){
				if(d[i]){
					answer = i;
					break;
				}
			}
			sb.append("Case #"+t+": "+answer+"\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}
class Node implements Comparable<Node>{
	int p;
	int s;
	public Node(int p, int s){
		this.p = p;
		this.s = s;
	}
	public int compareTo(Node n){
		return p+s<=(n.p+n.s)?-1:1;
	}
}