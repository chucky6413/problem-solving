/*
 * 2017.03.20
 * 시간초과나지만 깔끔. c++로는 돌아가는 코드.
 *
 * @problem https://www.acmicpc.net/problem/12430
 * @github https://github.com/chucky6413
 * @author chucky3
 */
import java.util.*;
import java.io.*;

public class Main {
	static int p[] = new int[1000];
	static int s[] = new int[1000];
	static boolean d[] = new boolean[101001];
	static List<Node> list = new ArrayList<Node>();
	public static void main(String arg[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		String temp[];
		int test = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=test;t++){
			int n = Integer.parseInt(br.readLine());
			list.clear();
			for(int i=0;i<n;i++){
				temp = br.readLine().split(" ");
				int si = Integer.parseInt(temp[0]);
				int pi = Integer.parseInt(temp[1]);
				list.add(new Node(si+pi,pi));
			}
			Collections.sort(list);
			Arrays.fill(d, false);
			d[0] = true;
			
			int bef_max = 0;
			int ans = 0;
			
			for(int i=0;i<n;i++){
				int now_max = bef_max;
				bef_max = Math.min(list.get(i).p - list.get(i).s, bef_max);
				for(int j=bef_max;j>=0;j--){
					if(d[j]){
						d[j + list.get(i).s] = true;
						now_max = Math.max(now_max,j+list.get(i).s);
					}
				}
				bef_max = now_max;
				ans = Math.max(ans, now_max);
			}
			sb.append("Case #"+t+": "+ans+"\n");
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