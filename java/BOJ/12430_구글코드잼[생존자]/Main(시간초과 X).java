/*
 * 2017.03.20
 * JAVA로 시간초과 안나는 코드
 *
 * @problem https://www.acmicpc.net/problem/12430
 * @github https://github.com/chucky6413
 * @author chucky3
 */
import java.util.*;
import java.io.*;

public class Main {
	static List<Node> list = new ArrayList<Node>(); //배열 d는 방문 배열로 사용할 것이다. 실제 이어갈 수 있는지..
	static boolean d[] = new boolean[101001]; // 101001인 이유 : 최대가능 지속시간 100000 , 최대 유통기한 1000 이므로
	static int answer;                        // 최대 유통기한까지 버티다 가장 큰 지속시간의 음식을 먹었을 때가 최대 결과이다.
	public static void main(String arg[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		String temp[];
		int test = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=test;t++){
			int max = 0; //max 초기화
			int n = Integer.parseInt(br.readLine());
			list.clear(); //list 초기화
			
			for(int i=0;i<n;i++){
				temp = br.readLine().split(" ");
				int pi = Integer.parseInt(temp[0]);
				int si = Integer.parseInt(temp[1]);
				list.add(new Node(pi,si));
			} //si 유통기한, pi 지속시간을 갖는 Node를 입력받는다.
			
			Collections.sort(list); //si+pi 순으로 정렬한다.
			max = list.get(n-1).p + list.get(n-1).s; //가장 맨뒤에 있는 Node의 p+s의 합을 max로 설정한다.
                                                     //존재할 수 있는 가장 최대 값이 될 수도 있으므로.(유통기한이 충족된다면)			
			answer = 0; //결과 값 초기화
			Arrays.fill(d, false); //방문 배열 초기화
			d[0] = true;
			
			for(int i=0;i<n;i++){ //Node의 수만큼 반복
				for(int j=list.get(i).p;j>=0;j--){ //해당 노드의 유통기한이 끝나기 전에 자신의 앞에서 지속된.. 음식이 있는지 
					if(d[j]){                      //찾아낸다.
						d[j+list.get(i).s] = true; //만약 현재 노드의 유통기한보다. 이어가는 지속된 음식이 있다면. 
					}                              //그 음식의 지속되던 시간 + 새로운 음식의 지속시간이 이용 가능하다고 true를 표시한다.
				}
			}
			for(int i=max;i>=0;i--){ //max = 결과값으로 가능한 가장 큰 값부터 시작해서.
				if(d[i]){ //이용가능한 최대값 true인 것을 찾아서
					answer = i; //찾아내자마자 정답에 대입한 후
					break; //반복문을 마친다. 뒤에서부터 시작하므로 찾자마자가 최대값이다.
				}
			}
			sb.append("Case #"+t+": "+answer+"\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}
class Node implements Comparable<Node>{
	int p;
	int s;
	public Node(int p, int s){
		this.p = p;
		this.s = s;
	}
	public int compareTo(Node n){
		return p+s<=(n.p+n.s)?-1:1;
	}
}