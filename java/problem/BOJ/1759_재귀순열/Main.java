/*
 * 2016.11.7
 * 재귀 순열
 */

import java.io.*;
import java.util.Arrays;

public class Main {
	static String input[];
	static String output[] = new String[16];
	static int L,C;
	
	public static void main(String arg[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		input = br.readLine().split(" ");
		L = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);
		
		input = br.readLine().split(" ");
		Arrays.sort(input); //오름차순 정렬
		permutation(0,0);
	}
	public static void permutation(int index,int len){
		if(len == L){
			String s="";
			int count = 0;
			for(int i=0;i<L;i++){
				s+=output[i];
				if("a".equals(output[i]) || "e".equals(output[i]) || "i".equals(output[i]) || "o".equals(output[i]) || "u".equals(output[i])){
					count++; //모음 개수 검사
				}
			}
			if(count>0 && L-count>1) //모음 1개 자음 2개 이상 맞는지
				System.out.println(s);
		}else{
			for(int i=index;i<C;i++){
				output[len]=input[i];
				permutation(i+1,len+1);
			}
		}
	}
}
