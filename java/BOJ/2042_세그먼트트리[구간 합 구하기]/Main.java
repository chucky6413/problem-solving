/*
 * 2017.02.17
 * 세그먼트 트리.
 *
 * @problem https://www.acmicpc.net/problem/2042
 * @github https://github.com/chucky6413
 * @author chucky3
 */
import java.util.*;
import java.io.*;	

public class Main {
	static long sumSegment[],answer; //세그먼트 트리 , 출력할 정답 변수
	static int n,m,k,select,queryL,queryR,changeIndex,changeValue,len=1;
	static String input[];
	public static void main(String arg[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		k = Integer.parseInt(input[2]);
		
		while(n*2>len){ 
			len*=2; //완전 이진트리 형태를 만들기 위한 len 값을 정한다.
		}
		sumSegment = new long[len]; //배열 생성
		for(int i=0;i<n;i++){
			sumSegment[len/2+i] = Integer.parseInt(br.readLine()); // leaf 노드의 값을 입력받아 대입한다.
		}
		segmentFill(1); // 세그 먼트 트리를 재귀 함수를 이용하여 구간 합을 채운다.
		
		for(int i=0;i<m+k;i++){
			input = br.readLine().split(" ");
			select = Integer.parseInt(input[0]);
			if(select==1){ //값 바꾸기
				changeIndex = Integer.parseInt(input[1]); //바꿀 위치
				changeValue = Integer.parseInt(input[2]); //바꿀 값
				changeIndex = changeIndex + (len/2-1); //리프 노드의 위치로 재설정 
				sumSegment[changeIndex] = changeValue; //값 바꾸기
				init(changeIndex); //초기화
				subSegmentFill(1); //부분 값 채우기.. 함수 설명은 해당 함수에.
			}else if(select==2){ //합
				queryL = Integer.parseInt(input[1]); //구간 왼쪽
				queryR = Integer.parseInt(input[2]); //구간 오른쪽
				answer = sumQuery(queryL,queryR,1,1,len/2); // 원하는 구간 l,r 시작 nodeIndex, 완전 이진트리의 구간 l,r 을 매개변수로 넘긴다.
				sb.append(answer+"\n"); //답 붙이기
			}
		}
		System.out.println(sb.toString()); //답 출력
	}
	public static long segmentFill(int nodeIndex){ // 세그먼트 트리를 채워주는 함수
		if(nodeIndex>=len/2) return sumSegment[nodeIndex]; //리프 노드에 해당하면 반환
		sumSegment[nodeIndex] = segmentFill(nodeIndex*2)+segmentFill(nodeIndex*2+1); //부모 노드에 자식 노드 둘의 합을 대입
		return sumSegment[nodeIndex];
	}
	public static long subSegmentFill(int nodeIndex){ //값이 변경된 부분의 부모에 해당하는 구간의 합들만 다시 채워준다.
		if(sumSegment[nodeIndex]!=-1) return sumSegment[nodeIndex];
		sumSegment[nodeIndex] = subSegmentFill(nodeIndex*2)+subSegmentFill(nodeIndex*2+1);
		return sumSegment[nodeIndex];
	}
	public static void init(int nodeIndex){ //리프노드의 값이 바뀐 부모들의 값들을 초기화 시킨다.
		if(nodeIndex<1) return;
		sumSegment[nodeIndex/2]=-1;
		init(nodeIndex/2);
	}
	public static long sumQuery(int queryL,int queryR,int nodeIndex,int nodeL,int nodeR){ // 구간을 매개변수로 받아 해당하는 합을 반환하는 함수
		if(queryR<nodeL || nodeR<queryL) return 0; //구하려는 구간과 설정된 node구간이 전혀 겹치지 않는 경우
		if(queryL<=nodeL && nodeR<=queryR) return sumSegment[nodeIndex]; //구간이 딱 맞을 때
		int middle = (nodeL+nodeR)/2; //현재 설정된 node 구간의 중간 값을 구한다.
		//구간이 딱 맞지 않는다면, 두 자식으로 나누어 작업을 하여 구간에 해당하는 값들을 구해온 후 그 합을 반환한다.
		return sumQuery(queryL,queryR,nodeIndex*2,nodeL,middle)+sumQuery(queryL,queryR,nodeIndex*2+1,middle+1,nodeR);
	}
}