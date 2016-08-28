/*
 * 2016.8.28
 * boj 1922
 * 네트워크 연결
 * disjointSet 자료구조를 이용하여 kruskal 알고리즘을 사용하여 해결.
 * 레드블랙 트리인 TreeMap -> 중복 key의 경우 value 안의 object에 line 을 연결하는 식으로 
 * MultiMap 처럼 사용
 */

import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.Map.*;
import java.util.ArrayList;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
	public static void main(String arg[]) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n,m;
		DisjointSet[] computer; //컴퓨터 set
		int count = 0; //신장 트리 
		int total = 0;
		
		st = new StringTokenizer(in.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine()," ");
		m = Integer.parseInt(st.nextToken());
		
		computer = new DisjointSet[n+1];
		
		for(int i=1;i<n+1;i++){
			computer[i] = new DisjointSet();
			computer[i].makeSet(computer[i]);
		}
		
		int p = 0;
		TreeMap<Integer,Line> lineMap = new TreeMap<Integer,Line>();
		
		for(int j=1;j<m+1;j++){
			p = 0;
			st = new StringTokenizer(in.readLine()," ");
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());			
			
			Line l = new Line(a,b);
			if(!lineMap.containsKey(c)){
				lineMap.put(c, l);
			}else{
				lineMap.getOrDefault(c, l).addLine(a, b);
			}
		}
		
		//오름차순 정렬
		
		
		int i=1;
		while(count<=n-1 && i <= m){
			for(int j=0;j<lineMap.get(lineMap.firstKey()).lineSize();j++){
				int u = lineMap.get(lineMap.firstKey()).getU(j);
				int v = lineMap.get(lineMap.firstKey()).getV(j);
				if(computer[u].findSet(computer[u]) != computer[v].findSet(computer[v])){
					count++;
					total += (lineMap.firstKey()).intValue();
					computer[u].union(computer[u], computer[v]);
				}
				i++;
			}
			lineMap.remove(lineMap.firstKey());
		}
		
		System.out.println(total);
	}
	public static class DisjointSet{
		private DisjointSet parent;
		private int rank;
		
		public void makeSet(DisjointSet x){
			this.parent = x;
			this.rank = 0;
		}
		public DisjointSet findSet(DisjointSet x){
			if(x.parent!=x){
				x.parent = findSet(x.parent);
			}
			return x.parent;
		}
		public void union(DisjointSet x,DisjointSet y){
			DisjointSet x1 = x.findSet(x);
			DisjointSet y1 = y.findSet(y);
			if(x1.rank > y1.rank){
				y1.parent = x1;
			}else{
				x1.parent = y1;
				if(x1.rank == y1.rank){
					y1.rank = y1.rank + 1;
				}
			}
		}
	}
	public static class Line{
		private ArrayList<Integer> u;
		private ArrayList<Integer> v;
		
		public Line(int u,int v){
			this.u = new ArrayList<Integer>();
			this.v = new ArrayList<Integer>();
			this.u.add(u);
			this.v.add(v);
		}
		public void addLine(int u,int v){
			this.u.add(u);
			this.v.add(v);
		}
		public int getU(int index){
			return u.get(index);
		}
		public int getV(int index){
			return v.get(index);
		}
		public int lineSize(){
			return u.size();
		}
	}
}