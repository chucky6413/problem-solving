/*
 * 2017.04.19
 * KMP
 * 
 * @problem https://www.acmicpc.net/problem/1786
 * @github https://github.com/chucky6413
 * @author chucky3
 */
import java.util.*;

public class Main{
	static char obj[];
	static char st[];
	static int fail[],count = 0;
	static final String NEWLINE = "\n";
	static StringBuilder sb = new StringBuilder();
	public static void main(String arg[]){
		Scanner input = new Scanner(System.in);
		obj = input.nextLine().toCharArray();
		st = input.nextLine().toCharArray();
		fail = new int[st.length];
		fail();
		comp();
		System.out.println(count);
		System.out.println(sb);
	}
	public static void comp(){
		for(int i=0,j=0;i<obj.length;i++){
			while(j>0 && obj[i]!=st[j]){ //¸ÅÄª ½ÇÆÐ
				j = fail[j-1];
			}
			if(obj[i]==st[j]){
				j++;
			}
			if(j==st.length){
				count++;
				sb.append(i-st.length+2+NEWLINE);
				j = fail[j-1];
			}
		}
	}
	public static void fail(){
		for(int i=1;i<st.length;i++){
			int index = fail[i-1];
			while(index>0 && st[i]!=st[index]){
				index = fail[index-1];
			}
			if(st[i]==st[index]){
				fail[i] = index+1;
			}else{
				fail[i] = 0;
			}
		}
	}
}