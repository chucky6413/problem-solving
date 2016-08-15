import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Random;

public class NTS {
	public static void main(String arg[]) throws IOException{
		
		HashMap<String,Integer> nts_hashTable = new HashMap<String,Integer>();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int count;
		Random random = new Random();
		
		System.out.print("java RecordMaker [count]\n");
		st=new StringTokenizer(in.readLine());
		st.nextToken();st.nextToken(); //java RecordMaker 버리기
		count=Integer.parseInt(st.nextToken()); //입력 받은 count 변수에 저장
		
		String e_Num,e="";
		int r,score;
		
		for(int i=0;i<count;){ //증감 조건식이 빠진 반복문입니다. 아래에 중복되지 않은 값 삽입시 증감식이 실행됩니다.
			r=random.nextInt(99999)+1;
			e=Integer.toString(r);
			if(r<10000){ //5자리 이하의 숫자일 경우 0으로 채웁니다.
				r=e.length();
				switch(r){
				case 1:
					e="0000"+e;
					break;
				case 2:
					e="000"+e;
					break;
				case 3:
					e="00"+e;
					break;
				case 4:
					e="0"+e;
					break;
				}
			}
			
			e_Num="NT"+e;
			if(!nts_hashTable.containsKey(e_Num)){ //중복된 값이 없다면 해쉬테이블에 연결합니다.
				score=random.nextInt(100);
				nts_hashTable.put(e_Num,score);
				sb.append(e_Num+" "+score+"\n");
				i++; //해당 조건의 경우만 i++
			}
		}
		System.out.println(sb.toString().substring(0,sb.length())); //출력시간을 줄이기 위해 저장 후 한번에 출력합니다.
	}
}
