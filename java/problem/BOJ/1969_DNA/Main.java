/*
 * 2016.12.11
 * 탐욕법
 * 백준 1969
 */
import java.util.Scanner;

public class Main {
	static String[] arr=new String[1000];
	static int count[] = new int[4];
	static final char ch[] = {'A','C','G','T'};
	static int result = 0;
	static StringBuilder dna = new StringBuilder();
	
	public static void main(String arg[]){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		for(int i=0;i<n;i++){
			arr[i]=sc.next();
		}
		
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){ 
				char t = arr[j].charAt(i);
				for(int c=0;c<4;c++){
					if(t==ch[c]){ //비교
						count[c]++;
					}
				}
			}
			int max=0,index=0;
			for(int c=0;c<4;c++){ 
				if(count[c]>max){ //사전순
					max=count[c];
					index=c;
				}
				count[c]=0;
			}
			result+=n-max;
			dna.append(ch[index]);
		}
		
		System.out.println(dna.toString());
		System.out.println(result);
	}
}
