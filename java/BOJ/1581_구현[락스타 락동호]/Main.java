/*
 * 2017.01.20
 * ±¸Çö
 *
 * @problem https://www.acmicpc.net/problem/1581
 * @author chucky3
 */
import java.util.*;

public class Main{
    public static void main(String arg[]){
        Scanner input = new Scanner(System.in);
        int FF = input.nextInt();
        int FS = input.nextInt();
        int SF = input.nextInt();
        int SS = input.nextInt();
        
        int result = 0;
        
        if(FF>0 || FS>0){
        	result+=FF;
        	if(FS>0){
        		result+=1;
            	FS-=1;
        		result+=SS;
        		int min = Math.min(SF,FS);
        		result+= 2*min;
        		SF-=min;
        		FS-=min;
        		if(SF>0)
        			result+=1;
        	}
        }else{
        	result+=SS;
        	if(SF>0)
        		result+=1;
        }
        
        System.out.println(result);
    }
}