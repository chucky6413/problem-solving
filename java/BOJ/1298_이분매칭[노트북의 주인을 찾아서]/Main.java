/*
 * 2017.01.11
 * 이분 매칭,최대 유량
 * 
 * @problem https://www.acmicpc.net/problem/1298
 * @github https://github.com/chucky6413/Algorithm-study/tree/master/java/BOJ
 * @author chucky3
 */
import java.util.*;

public class Main {
	static int n,m,result = 0;
	static int people[],notebook[];
	static boolean visited[];
	static List<Integer> list[];
	
	public static void main(String arg[]){
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		m = input.nextInt();
		
		people = new int[n+1];
		notebook = new int[n+1];
		visited = new boolean[n+1];
		list = new ArrayList[n+1];
		
		for(int i=1;i<n+1;i++){
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i=0;i<m;i++){
			int a = input.nextInt();
			int b = input.nextInt();
			list[a].add(b);
		}
		
		for(int i=1;i<=n;i++){
			if(people[i]==0){
				Arrays.fill(visited, false);
				if(dfs(i))
					result++;
			}
		}
		
		System.out.println(result);
	}
	public static boolean dfs(int v){
		visited[v] = true;
		for(int i=0;i<list[v].size();i++){
			int sel = list[v].get(i);
			if(notebook[sel]==0 || !visited[notebook[sel]] && dfs(notebook[sel])){
				people[v]=sel;
				notebook[sel]=v;
				return true;
			}
		}
		return false;
	}
}