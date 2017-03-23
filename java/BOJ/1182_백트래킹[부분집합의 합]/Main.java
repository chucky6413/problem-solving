/*
 * 2017.03.23
 * 백트래킹,완전탐색
 *
 * @problem https://www.acmicpc.net/problem/1182
 * @github https://github.com/chucky6413
 * @author chucky3
 */
import java.util.*;
import java.io.*;

public class Main {
	static int N,S,result=0,count=0;
	static List<Integer> list = new LinkedList<Integer>();
	static String temp[];
	public static void main(String arg[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		temp = br.readLine().split(" ");
		N = Integer.parseInt(temp[0]);
		S = Integer.parseInt(temp[1]);
		
		temp = br.readLine().split(" ");
		for(int i=0;i<temp.length;i++){
			list.add(Integer.parseInt(temp[i]));
		}
		
		solve(0); //탐색
		System.out.println(count);
	}
	public static void solve(int index){
		if(index==N) return; //마지막 원소
		if(result+list.get(index)==S) count++;
		
		solve(index+1); //다음 원소 넣기
		
		result+=list.get(index); //이번 값 포함해서
		solve(index+1); //다음 원소 넣기
		
		result-=list.get(index); //값 빼주기
	}
}