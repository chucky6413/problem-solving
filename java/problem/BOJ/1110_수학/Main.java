/*
 * 2016.11.26
 * 수학.
 * 백준 1110
 */

import java.util.Scanner;
import java.util.Arrays;
  
public class Main {
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	int[] first = new int[2];
    	int[] result = new int[2];
    	int[] temp = new int[2];
    	
    	String s = sc.next();
    	first[0]=Integer.parseInt(s.length()>1?s.charAt(0)+"":"0");
    	first[1]=Integer.parseInt(s.length()>1?s.charAt(1)+"":s.charAt(0)+"");
    	int count=0;
    	result=Arrays.copyOf(first, 2);
    	do{
    		temp[0]=result[1];
    		temp[1]=(result[0]+result[1])%10;
    		result=Arrays.copyOf(temp, 2);
    		count++;
    	}while(!Arrays.equals(first, result));
    	
    	System.out.println(count);
    }
}