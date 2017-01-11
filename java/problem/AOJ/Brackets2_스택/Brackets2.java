/*
 * 2016.11.05
 * 짝이 맞지 않은 괄호 문제..
 * LinkedList 를 이용한 Stack 으로 간단하게 해결..
 *
 * @author chucky3
 */

import java.io.*;
import java.util.List;
import java.util.LinkedList;

public class Brackets2 {
	public static void main(String arg[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int C =Integer.parseInt(br.readLine());
		String result[] = new String[C];
		List<Character> list;
		
		for(int i=0;i<C;i++){
			list = new LinkedList<Character>();
			String s = br.readLine();
			
			for(int j=0;j<s.length();j++){
				char word = s.charAt(j);
				
				if(word=='[' || word=='{' || word=='('){
					list.add(word);
				}else{
					if(!(list.size()>0)){
						result[i]="NO";
						break;
					}
					
					char pop = list.get(list.size()-1);
					list.remove(list.size()-1);
					if(word==']' && pop=='[')
						continue;
					else if(word=='}' && pop=='{')
						continue;
					else if(word==')' && pop=='(')
						continue;
					else{
						result[i]="NO";
						break;
					}
				}
			}
			if(list.size()==0 && result[i]!="NO"){
				result[i]="YES";
			}else{
				result[i]="NO";
			}
		}
		
		for(int i=0;i<C;i++){
			System.out.println(result[i]);
		}
	}
}
