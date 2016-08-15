//******************************************************
 // 파일명: hw10_1.java
 // 작성자: 이준우
 // 작성일: 2015.11.19
 // 내용:  UndirectedGraph의 깊이 우선 탐색 프로그램
 //******************************************************
import java.util.*;

abstract class UndirectedGraph{
	int addEdge(int v1,int v2){return 1;};
	int printAdjacentVertecies(int n){return 1;};
	void depthFirstSearch(int v){};
	void BreadthFirstSearch(int v){};
}

class StackNode{
	int data;
	StackNode link;
}

class LinkedStack{
	StackNode top;
	 
	public boolean isEmpty(){
		 return (top==null);
	}
	 
	public void push(int item){
		StackNode newNode = new StackNode();
		newNode.data=item;
		newNode.link=top;
		top=newNode;
	}
	public int pop(){
		if(isEmpty()){
			System.out.println("pop 연산 실패");
			return 0;
		}
		else{
			int item=top.data;
			top=top.link;
			return item;
		}
	}
}
class QNode{
	int data;
	QNode link;
}
class LinkedQueue{
	QNode front;
	QNode rear;
	
	public LinkedQueue(){
		front = null;
		rear = null;
	}
	public boolean isEmpty(){
		return (front==null);
	}
	public void enQueue(int item){
		QNode newNode = new QNode();
		newNode.data = item;
		newNode.link = null;
		if(isEmpty()){
			front = newNode;
			rear = newNode;
		}
		else{
			rear.link = newNode;
			rear = newNode;
		}
	}
	public int deQueue(){
		if(isEmpty()){
			System.out.println("deQueue 실패!!");
			return 0;
		}
		else{
			int item=front.data;
			front=front.link;
			if(front==null){
				rear=null;
			}
			return item;
		}
	}
}

class GraphNode{
	int vertex;
	GraphNode link;
}
class AdjList extends UndirectedGraph{
	private GraphNode head[];
	private int totalV=0;
	
	public AdjList(int v){
		head=new GraphNode[v];
		totalV=v;
	}
	public int min(){ //최소 정점을 찾아주는 함수
		int v=0;
		while(v<totalV)
		{
			if(head[v]!=null)
				return v;
			else
				v++;
		}
		return -1;
	}
	public int addEdge(int v1,int v2){
		if(v1>=totalV||v2>=totalV||v1<0||v2<0){ //간선 삽입시 잘못된 정점이 입력될시 1반환
			if(v1>=totalV||v1<0){
				System.out.println(v1+"은/는 그래프에 없는 정점입니다!");
				return 0;
			}
			else
				System.out.println(v2+"은/는 그래프에 없는 정점입니다!");
				return 0;	
		}
		else{
			GraphNode eNode = new GraphNode();
			eNode=head[v1]; //중복된 간선 검사용 노드
			while(eNode!=null){ 
				if(eNode.vertex==v2){ //중복된 간선이 있을 시 0 을 반환하고 main에서 재입력을 유도한다.
					System.out.println("중복된 간선입니다.");
					return 0;
				}
				else
					eNode=eNode.link;
			}
			GraphNode gNode = new GraphNode();
			gNode.vertex=v2;
			gNode.link=head[v1];
			head[v1]=gNode;
			if(head[v1].link!=null)
				if(gNode.vertex>gNode.link.vertex) //간선 삽입시 인접 정점들의 크기를 비교하여 오름차순으로 정렬시켜주는
					sortG(gNode,v1); //sortG 호출
				
			GraphNode gNode2 = new GraphNode();
			gNode2.vertex=v1;
			gNode2.link=head[v2];
			head[v2]=gNode2;
			if(head[v2].link!=null)
				if(gNode2.vertex>gNode2.link.vertex)
					sortG(gNode2,v2);
			return 1;
		}
	}
	public void sortG(GraphNode g,int v){
		head[v]=sortGraph(g);
	}
	public GraphNode sortGraph(GraphNode g){ //오름차순 정렬메소드
		GraphNode gNode=g;

		GraphNode temp=new GraphNode();
		temp.link=gNode.link.link;
		gNode.link.link=gNode;
		gNode=gNode.link;
		gNode.link.link=temp.link;
		if(gNode.link.link!=null)
			if(gNode.link.vertex>gNode.link.link.vertex)
				gNode.link=sortGraph(gNode.link);
		return gNode;
	}
	public int printAdjacentVertecies(int n){
		if(n>=totalV||n<0){ //잘못된 정점 입력시 0 반환
			System.out.println(n+"은/는 그래프에 없는 정점입니다!");
			return 0;
		}
		else{
		GraphNode gNode = new GraphNode();
		System.out.print(n+"에 인접한 정점 : ");
		gNode=head[n];
		while(gNode!=null){
			System.out.printf("%d ",gNode.vertex);
			gNode=gNode.link;
		}
		System.out.println();
		return 1;
		}
	}
	public void depthFirstSearch(int v){
		GraphNode w=new GraphNode();
		GraphNode b=new GraphNode();
		LinkedStack S=new LinkedStack();
		boolean visited[]=new boolean[10];
		S.push(v);
		visited[v]=true;
		System.out.printf("%d ",v);
		while(S.top!=null){
			w=head[v];
			while(w!=null){
				if(visited[w.vertex]==false){
					S.push(w.vertex);
					visited[w.vertex]=true;
					System.out.printf("%d ", w.vertex);
					v=w.vertex;
					w=head[v];
				}
				else w=w.link;
			}
			v=S.pop();
			if(v==min()){
				b=head[v];
				while(b!=null)
				{
					if(visited[b.vertex]==false)
					{
						S.push(v);
						break;
					}
					b=b.link;
				}
			}
		}
		System.out.println();
	}
	public void BreadthFirstSearch(int v){
		GraphNode w = new GraphNode();
		LinkedQueue Q = new LinkedQueue();
		boolean visited[] = new boolean[10];
		visited[v]=true;
		System.out.print(v+" ");
		Q.enQueue(v);
		while(!Q.isEmpty()){
			v=Q.deQueue();
			for(w=head[v];w!=null;w=w.link){
				if(visited[w.vertex]==false){
					visited[w.vertex]=true;
					System.out.print(w.vertex+" ");
					Q.enQueue(w.vertex);
				}
			}
		}
	}
}

public class UndirectedGraphTest{
	public static void main(String arg[]){
		System.out.println("hw10_1 : 이준우\n");
		int sel=0,n=0;
		int e=0; //오류 찾기 위한 변수
		Scanner input=new Scanner(System.in);
		while(e==0){
		System.out.print("정점 수 입력 : ");
		n=input.nextInt();
		if(n>=0&&n<11) //boolean 배열의 크기를 10으로 지정했으므로 n이 음수가 아니고 10보다 작을 시 성공.
			e=1;
		else
			System.out.println("0이상 10이하의 숫자를 입력하시오.");
		}
		AdjList a = new AdjList(n);
		while(sel!=5){
			System.out.println();
			int v,v1,v2;
			System.out.print("1:간선삽입 2:인접정점보기 3:깊이우선탐색 4:너비우선탐색 5:종료-->");
			sel=input.nextInt();
			switch(sel){
			case 1:
				e=0;
				while(e==0){ //잘못된 정점으로 인해 삽입에 실패할 경우 반복 입력
				System.out.print("삽입할 간선을 입력하세요(정점 번호 2개):");
				v1=input.nextInt();
				v2=input.nextInt();
				e=a.addEdge(v1, v2);
				}
				break;
			case 2:
				e=0;
				while(e==0){ //잘못된 정점번호 입력시 반복 입력
				System.out.print("정점 번호를 입력하세요 : ");
				v=input.nextInt();
				e=a.printAdjacentVertecies(v);
				}
				break;
			case 3:
				System.out.print("깊이우선탐색 : ");
				if(a.min()!=-1)
					a.depthFirstSearch(a.min());
				break;
			case 4:
				System.out.print("너비우선탐색 : ");
				e=a.min();
				if(a.min()!=-1)
					a.BreadthFirstSearch(a.min());
				break;
			case 5:
				break;
			}
		}
		
	}
}