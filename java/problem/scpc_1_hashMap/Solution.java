import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Collection;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.HashMap;

public class Solution{
	public static void main(String[] arg) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		int t = Integer.parseInt(st.nextToken()); //test case 수
		
		
		for(int i=1;i<=t;i++){
			st = new StringTokenizer(in.readLine()," ");
			int n = Integer.parseInt(st.nextToken()); //숫자 몇번 나올지..
			int result = 0; //결과
			st = new StringTokenizer(in.readLine()," ");
			HashMap<Integer,Item> map = new HashMap<Integer,Item>();
			while(st.hasMoreTokens()){
				int num = Integer.parseInt(st.nextToken());
				if(map.containsKey(num)){ //이미 나온 적 있다면.. ++
					map.get(num).addCount();
				}else{
					map.put(num, new Item(num,1));
				}
			}
			Collection<Item> list = map.values();
			Iterator<Item> e = list.iterator();
			int j=-1; //첫변수 찾기 위함
			while(e.hasNext()){
				Item item = (Item) e.next();
				if(item.getCount()%2==1){
					if(j==-1){
						result=item.getKey();
						j=0;
					}else{
						result^=item.getKey();
					}
				}
			}
			
			System.out.println("Case #" + i);
			System.out.println(result);
		}
	}
	public static class Item{
		private int key;
		private int count;
		
		public Item(int key,int count){
			this.key = key;
			this.count = count;
		}
		public int getKey(){
			return key;
		}
		public int getCount(){
			return count;
		}
		public void addCount(){
			count++;
		}
	}
}