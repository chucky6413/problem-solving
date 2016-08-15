//****************************************************************
// 파일명: BinarySearchTree.java
// 작성자:이준우
// 작성일: 2016-05-13
// 내용: 키값과 포인트를 저장하는 이진검색트리 클래스
//****************************************************************

public class BinarySearchTree {
	private Node root=null;
	private int size=0;
	
	//service method
	public void print(){
		inorder(root);
		System.out.println("\n");
	}
	
	public int size(){
		return size;
	}
	
	public boolean contains(int id){
		if(treeSearch(root,id)==null) 
			return false;
		else
			return true;
	}
	
	public boolean add(int id){
		if(treeSearch(root,id)!=null){
			System.out.print("중복된 값은 삽입이 불가능합니다.\n");
			return false;
		}
		root=treeInsert(root,id);
		if(treeSearch(root,id)==null)
			return false;
		else{
			size++;
			return true;
		}
	}
	public int get(int id){
		Node n = treeSearch(root,id);
		if(n==null)
			return -1;
		else
			return n.point;
	}
	public boolean set(int id,int point){
		Node n = treeSearch(root,id);
		if(n==null)
			return false;
		else{
			n.point+=point;
			return true;
		}
	}
	//support method
	private void inorder(Node t){
		if(t!=null){
			inorder(t.left);
			System.out.print("("+t.key+","+t.point+") ");
			inorder(t.right);
		}
	}
	
	private Node treeSearch(Node t,int x){
		if(t==null || t.key==x)
			return t;
		else if(x<t.key)
			return treeSearch(t.left,x);
		else
			return treeSearch(t.right,x);
	}
	
	private Node treeInsert(Node t,int x){
		if(t==null){
			Node r=new Node(x);
			return r;
		}else if(x<t.key){
			t.left=treeInsert(t.left,x);
			return t;
		}else{
			t.right=treeInsert(t.right,x);
			return t;
		}
	}
	
	private class Node{
		int key;
		int point;
		Node left;
		Node right;
		
		public Node(int key){
			this.key=key;
			this.point=0;
		}
	}
}
