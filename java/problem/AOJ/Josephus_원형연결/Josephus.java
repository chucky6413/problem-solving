/*
 * 2016.11.5
 * 조세푸스 문제.. 원형 연결리스트를 흉내낸 연산으로..
 * 해결 매우 간단.
 *
 * @author chucky3
 */

import java.io.*;
import java.util.List;
import java.util.LinkedList;

public class Josephus {
	static int result[][];
	static List<Integer> list;
	static int arr[];
	
	public static void main(String arg[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int c = Integer.parseInt(br.readLine());
		
		result = new int[c][2];
		
		for(int i=0;i<c;i++){
			String temp[] = br.readLine().split(" ");
			int size = Integer.parseInt(temp[0]);
			int k = Integer.parseInt(temp[1]);
			list = new LinkedList<Integer>();
			
			for(int j=1;j<=size;j++){
				list.add(j);
			}
			
			int spot = 0;
			
			while(list.size()>2){
				list.remove(spot);
				spot = (spot+k-1)%list.size();
			}
			
			result[i][0] = list.get(0);
			result[i][1] = list.get(1);
		}
		for(int i=0;i<c;i++){
			System.out.println(result[i][0]+" "+result[i][1]);
		}
		
	}
}
