/*
 * 2017.03.17
 * 다익스트라 알고리즘
 *
 * @problem https://www.acmicpc.net/problem/1916
 * @github https://github.com/chucky6413
 * @author chucky3
 */
import java.util.*;
import java.io.*;

public class Main {
	public static int s,d,n,m,INF = 100000001; //도시 1000개, 최대 비용 100000
	public static List<Node> city[]; //도시
	public static int totalCost[]; //총 비용
	public static void main(String arg[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp[];
		
		n = Integer.parseInt(br.readLine()); //도시 개수
		m = Integer.parseInt(br.readLine()); //버스 개수
		
		city = new LinkedList[n+1]; //도시 배열 생성
		totalCost = new int[n+1]; //총 비용 배열 생성
		
		for(int i=1;i<=n;i++){ //도시 배열의 LinkedList 객체를 각각 생성
			city[i] = new LinkedList<Node>();
		}
		
		for(int i=1;i<=n;i++){ //총 비용 초기화 ( 무한대 = 최대 나올 수 있는 비용의 값 INF 를 대입 )
			totalCost[i] = INF;
		}
		
		for(int i=0;i<m;i++){ //입력 받기 시작 도시 -> 도착 도시 , 버스 비용
			temp = br.readLine().split(" ");
			int start = Integer.parseInt(temp[0]); //시작 도시 대입
			int dest = Integer.parseInt(temp[1]); //도착 도시 대입
			int cost = Integer.parseInt(temp[2]); //버스 비용 대입
			
			city[start].add(new Node(dest,cost)); //시작 도시로 부터 연결된 도착 도시와 비용 add
		}
		
		temp = br.readLine().split(" ");
		s = Integer.parseInt(temp[0]); //우리가 구할 시작점
		d = Integer.parseInt(temp[1]); //우리가 구할 도착점
		
		PriorityQueue<Node> queue = new PriorityQueue<Node>(); //우선 순위 큐 생성
		totalCost[s] = 0; //시작점으로부터 시작점까지 거리는 0
		queue.offer(new Node(s,0)); //시작 도시 노드를 queue에 offer
		
		while(!queue.isEmpty()){ //큐가 빌 때 까지 반복
			int v = queue.poll().index; //큐의 처음 노드를 뽑아 도시 번호 추출
			
			for(int i=0;i<city[v].size();i++){ // 위에서 뽑은 도시에서 갈 수 있는 도착 도시들의 개수 만큼 반복
				int adj = city[v].get(i).index; //위에서 뽑은 도시와 인접한 도시 번호 추출
				
				if(totalCost[adj]>totalCost[v]+city[v].get(i).cost){ //비용 비교
					totalCost[adj] = totalCost[v]+city[v].get(i).cost; //최소 비용이면 대입
					queue.offer(new Node(adj,totalCost[adj])); //큐에 add
				}
			}
		}
		System.out.println(totalCost[d]); //최종 답 출력.
	}
}
class Node implements Comparable<Node>{
	int index;
	int cost;
	
	public Node(int index,int cost){
		this.index = index;
		this.cost = cost;
	}
	
	public int compareTo(Node n){
		return cost<n.cost ? -1 : 1;
	}
}