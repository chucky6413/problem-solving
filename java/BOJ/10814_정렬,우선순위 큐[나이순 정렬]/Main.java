/*
 * 2017.01.11
 * 정렬,우선순위 큐
 * 
 * @problem https://www.acmicpc.net/problem/10814
 * @author chucky3
 */
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String arg[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Member> queue = new PriorityQueue<Member>();
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0;i<n;i++){
			String temp[] = br.readLine().split(" ");
			Member m = new Member(Integer.parseInt(temp[0]),temp[1]);
			queue.add(m);
		}
		
		
		while(!queue.isEmpty()){
			sb.append(queue.poll().toString()+"\n");
		}
		
		System.out.println(sb.toString());
	}
}
class Member implements Comparable<Member>{
	static int count = 0; //가입 순서
	
	int age;
	String name;
	int registerNumber;
	
	public Member(int age,String name){
		this.age = age;
		this.name = name;
		this.registerNumber = count++;
	}
	public int compareTo(Member m){
		if(age==m.age){
			return registerNumber-m.registerNumber;
		}
		return age-m.age;
	}
	public String toString(){
		return age+" "+name;
	}
}