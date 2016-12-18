/*
 * 2016.12.18
 * 동적계획법
 * 백준 1463
 */
import java.util.Scanner;

public class Main {
	static int num=0;
	static int d[]=new int[10000001];
	public static void main(String arg[]){
		Scanner input = new Scanner(System.in);
		num=input.nextInt();
		
		d[1]=0;
		for(int i=2;i<=num;i++){
			int min=d[i-1];
			if(i%3==0){
				min=Math.min(min,d[i/3]);
			}else if(i%2==0){
				min=Math.min(min,d[i/2]);
			}
			d[i]=min+1;
		}
		
		System.out.println(d[num]);
	}
}