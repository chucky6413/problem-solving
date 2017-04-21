/*
 * 2017.04.22
 * Å½¿å¹ý
 * 
 * @problem https://www.acmicpc.net/problem/10610
 * @github https://github.com/chucky6413
 * @author chucky3
 */

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	static BigInteger ans;
	static char[] n;
	public static void main(String args[]) throws IOException{
		Scanner input = new Scanner(System.in);
		StringBuilder sb;
		n = input.next().toCharArray();
		Arrays.sort(n);
		
		sb = new StringBuilder(String.copyValueOf(n));
		sb = sb.reverse();
		ans = new BigInteger(sb.toString());
		
		if(ans.mod(new BigInteger("30")).equals(new BigInteger("0"))){
			System.out.println(ans);
		}else{
			System.out.println(-1);
		}
	}
}
