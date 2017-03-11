/*
 * 2017.01.20
 * 구현
 *
 * @problem https://www.acmicpc.net/problem/1592
 * @github https://github.com/chucky6413/Algorithm-study/tree/master/java/BOJ
 * @author chucky3
 */
import java.util.*;

public class Main{
	public static void main(String arg[]){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int l = input.nextInt();
        
        int count[] = new int[n];
        int result = 0,pick = 0;
        count[0]=1;
        
        while(true){
        	if(count[pick]==m){ 
        		break;
        	}else if(count[pick]%2==0){
        		pick=(pick+l)%n;
        	}else{
        		pick=((pick-l)%n+n)%n;
        	}
        	count[pick]++;
        	result++; //결과 횟수 증가
        }
        System.out.println(result);
    }
}