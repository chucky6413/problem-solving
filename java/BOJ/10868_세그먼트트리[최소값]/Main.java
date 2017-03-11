/*
 * 2017.02.17
 * 세그먼트 트리.
 *
 * @problem https://www.acmicpc.net/problem/10868
 * @github https://github.com/chucky6413/Algorithm-study/tree/master/java/BOJ
 * @author chucky3
 */
import java.util.*;
	
public class Main {
	static int minSegment[]; //구간 최소 값을 저장할 세그먼트 트리
	static int n,m,queryL,queryR,len=1,answer;
	public static void main(String arg[]){
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		m = input.nextInt();
		
		while(n*2>len){ 
			len*=2; //완전 이진트리 형태를 만들기 위한 len 값을 정한다.
		}
		minSegment = new int[len]; //배열 생성
		for(int i=0;i<n;i++){
			minSegment[len/2+i] = input.nextInt(); // leaf 노드의 값을 입력받아 대입한다.
		}
		segmentFill(1); // 세그 먼트 트리를 재귀 함수를 이용하여 min 값을 채운다.
		
		for(int i=0;i<m;i++){
			queryL = input.nextInt();
			queryR = input.nextInt();
			answer = minQuery(queryL,queryR,1,1,len/2); // 원하는 구간 l,r 시작 nodeIndex, 완전 이진트리의 구간 l,r 을 매개변수로 넘긴다.
			System.out.println(answer);
		}
	}
	public static int segmentFill(int nodeIndex){ // 세그먼트 트리를 채워주는 함수
		if(nodeIndex>=len/2) return minSegment[nodeIndex]; //리프 노드에 해당하면 반환
		minSegment[nodeIndex] = Math.min(segmentFill(nodeIndex*2),segmentFill(nodeIndex*2+1)); //부모 노드에 자식 노드 둘 중 작은 노드의 값을 대입
		return minSegment[nodeIndex];
	}
	public static int minQuery(int queryL,int queryR,int nodeIndex,int nodeL,int nodeR){ // 구간을 매개변수로 받아 해당하는 최소 값을 반환하는 함수
		if(queryR<nodeL || nodeR<queryL) return 1000000001; //구하려는 구간과 설정된 node구간이 전혀 겹치지 않는 경우
		if(queryL<=nodeL && nodeR<=queryR) return minSegment[nodeIndex]; //구간이 딱 맞을 때
		int middle = (nodeL+nodeR)/2; //현재 설정된 node 구간의 중간 값을 구한다.
		//구간이 딱 맞지 않는다면, 두 자식으로 나누어 작업을 하여 구간에 해당하는 값들을 구해온 후 그 중 최소값을 반환한다.
		return Math.min(minQuery(queryL,queryR,nodeIndex*2,nodeL,middle),minQuery(queryL,queryR,nodeIndex*2+1,middle+1,nodeR));
	}
}