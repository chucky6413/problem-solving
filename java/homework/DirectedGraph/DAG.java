//****************************************************************
// 파일명: DirectedGraph.java
// 작성자:이준우
// 작성일: 2016-6-02
// 내용: DAG의 위상정렬을 구현한 프로그램
//****************************************************************
public class DAG {
	private Node[] list;
	private int numberOfVertices;
	private int numberOfEdges;
	
	private boolean[] visited;
	private boolean[] finalize;//cycle 검사를 위한 배열
	private Node R; //위상정렬을 위한 Node
	
	private class Node{
		int vertex;
		Node next;
	}
	//생성자
	public DAG(int v,int e){
		list = new Node[v];
		visited = new boolean[v];
		finalize = new boolean[v];
		numberOfVertices = v;
		numberOfEdges=e;
	}
	
	public void link(int v1,int v2){
		Node newnode = new Node();
		newnode.vertex=v2;
		newnode.next=list[v1];
		list[v1]=newnode;
	}
	public void print(){
		  for(int i=0; i<numberOfVertices; i++) {
			   Node first = list[i];
			   System.out.print("정점"+i+"의 인접리스트 ");
			   while(first!=null){
			    System.out.print("-->"+first.vertex);
			    first=first.next;
			   }
			   System.out.println(); 
		  }
	}
	public boolean topologicalSort2(){
		boolean cycle;
		for(int i=0;i<numberOfVertices;i++){
			visited[i]=false;
			finalize[i]=false;
		}
		for(int i=0;i<numberOfVertices;i++)
			if(!visited[i]){
				cycle=DFS_TS(i);
				if(cycle)
					return false; //DAG가 아닐 경우 종료
			}
		
		//위상정렬 결과 출력
		Node first = R;
		System.out.print("\n위상정렬 결과 : ");
		while(first!=null){
			System.out.print(first.vertex+" ");
			first=first.next;
		}
		return true;
	}
	public boolean DFS_TS(int v){
		visited[v] = true;
		Node first = list[v];
		while(first!=null){
			if(!visited[first.vertex])
				DFS_TS(first.vertex);
			if(visited[first.vertex] && !finalize[first.vertex]) //visited 인데 finalize가 아니라면 cycle이 존재하는 것이다.
				return true;
			first=first.next;
		}
		//연결 리스트 R의 맨 앞에 정점 V를 삽입한다.
		Node newnode = new Node();
		newnode.vertex=v;
		newnode.next=R;
		R=newnode;
		finalize[v] = true; //마무리 짓는 finalize
		return false;
	}
}
