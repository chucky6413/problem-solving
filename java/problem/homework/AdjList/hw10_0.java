//******************************************************
 // 파일명: hw10_0.java
 // 작성자: 이준우
 // 작성일: 2015.11.17
 // 내용:  adjacency list를 이용한 그래프 구현
 //******************************************************
import java.util.*;

class GraphNode{
	int vertex;
	GraphNode link;
}
class AdjList{
	private GraphNode head[];
	private int totalV=0;
	
	public AdjList(int v){
		head=new GraphNode[v];
		totalV=v;
	}
	public void addEdge(int v1,int v2){
		if(v1>=totalV||v2>=totalV)
			System.out.println("그래프에 없는 정점입니다!");
		else{
			GraphNode gNode = new GraphNode();
			gNode.vertex=v2;
			gNode.link=head[v1];
			head[v1]=gNode;
			
			GraphNode gNode2 = new GraphNode();
			gNode2.vertex=v1;
			gNode2.link=head[v2];
			head[v2]=gNode2;
		}
	}
	public void printAdjacentVertecies(int n){
		GraphNode gNode = new GraphNode();
		System.out.print(n+"에 인접한 정점 : ");
		gNode=head[n];
		while(gNode!=null){
			System.out.printf("%d ",gNode.vertex);
			gNode=gNode.link;
		}
		System.out.println();
	}
}

public class hw10_0{
	public static void main(String arg[]){
		System.out.println("hw10_0 : 이준우\n");
		int sel=0,n;
		Scanner input=new Scanner(System.in);
		System.out.print("정점 수 입력 : ");
		n=input.nextInt();
		AdjList a = new AdjList(n);
		while(sel!=3){
			System.out.println();
			int v,v1,v2;
			System.out.print("1:간선삽입 2:인접정점보기 3:종료-->");
			sel=input.nextInt();
			switch(sel){
			case 1:
				System.out.print("삽입할 간선을 입력하세요(정점 번호 2개):");
				v1=input.nextInt();
				v2=input.nextInt();
				a.addEdge(v1, v2);
				break;
			case 2:
				System.out.print("정점 번호를 입력하세요 : ");
				v=input.nextInt();
				a.printAdjacentVertecies(v);
				break;
			case 3:
				break;
			}
		}
		
	}
}