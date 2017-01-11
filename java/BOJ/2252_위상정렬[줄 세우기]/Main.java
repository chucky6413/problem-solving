/*
 * 2016.08.20
 * 위상정렬
 *
 * @problem https://www.acmicpc.net/problem/2252
 * @author chucky3
 */

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;
import java.lang.StringBuilder;

public class Main{
	private static boolean visited[];
	private static LinkedList<Integer> result;
	
	public static void main(String arg[]){
		
		Scanner input = new Scanner(System.in);
		
		List<LinkedList<Integer>> list = new ArrayList<LinkedList<Integer>>();
		
		int n,m;
		
		n = input.nextInt();
		visited = new boolean[n+1];
		
		for(int i=0;i<n+1;i++){
			LinkedList<Integer> l = new LinkedList<Integer>();
			list.add(l);
		}
		m = input.nextInt();
		
		int front,back;
		for(int i=0;i<m;i++){
			front = input.nextInt();
			back = input.nextInt();
			
			list.get(front).add(back);
		}
		
		result = new LinkedList<Integer>();
		topologicalSort2(list,n,m);
		
		Iterator iterator = result.iterator();
		StringBuilder sb = new StringBuilder();
		while(iterator.hasNext()){
			sb.append(iterator.next()+" ");
		}
		
		System.out.println(sb);				
	}
	public static void topologicalSort2(List<LinkedList<Integer>> list, int n , int m){
		for(int i=1;i<n+1;i++){
			visited[i] = false;
		}
		for(int i=1;i<n+1;i++){
			if(!visited[i]){
				dfs(list,i);
			}
		}
	}
	public static void dfs(List<LinkedList<Integer>> list, int v){
		visited[v] = true;
		Iterator iterator = list.get(v).iterator();
		while(iterator.hasNext()){
			int x = (int) iterator.next();
			if(!visited[x]){
				dfs(list,x);
			}
		}
		result.addFirst(v);
	}
}