//****************************************************************
// 파일명: Hash.java
// 작성자:이준우
// 작성일:2016-05-09
// 내용: 정수배열,테이블 크기와 여러가지 메소드를 갖고 있는 Hash 클래스
//****************************************************************

public class Hash {
	private static int t[]=null;
	private static int size=0;
	
	public Hash(int size){ //생성자. 알고리즘의 null을 의미하는 -1을 대입해줍니다.
		this.size=size;
		t=new int[size];
		for(int i=0;i<size;i++)
			t[i]=-1;
	}
	
	public static void insert(int x){
		int db=hashSearch(x);
		if(db==-1){
			int	error=hashInsert(x);
			if(error==-1){
				System.out.println("삽입 실패(테이블이 가득 찼습니다)\n");
			}else{
				System.out.println("삽입 성공\n");
			}
		}else{
			System.out.println("중복된 값을 삽입할 수 없습니다.\n");
		}
	}
	public static void search(int x){
		int error=hashSearch(x);
		if(error==-1){
			System.out.println("검색 실패\n");
		}else{
			System.out.println("테이블의 "+error+"인덱스에 값 "+x+"가 존재합니다.\n");
		}
	}
	public static void delete(int x){
		int db=hashSearch(x);
		if(db==-1){
			System.out.println("삭제할 값이 존재하지 않습니다.\n");
		}else{
			hashDelete(db);
			System.out.println("삭제 성공\n");
		}
	}
	public static void print(){
		hashPrint();
	}
	
	//내부 메소드
	private static int h(int i,int x){
		return (i+x)%size;
	}
	private static int hashInsert(int x){
		int i=0;
		int j=0;
		do{
			j=h(i,x);
			if(t[j]==-1 || t[j]==-2){ //null 이거나 DELETED 일때는 삽입 가능.
				t[j]=x;
				return j;
			}else{
				i++;
			}
		}while(i<size);
		
		System.out.println("테이블 오버플로우");
		return -1;
	}
	private static int hashSearch(int x){
		int i=0;
		int j=0;
		do{
			j=h(i,x);
			if(t[j]==x){
				return j;
			}else{
				i++;
			}
		}while(t[j]!=-1 && i<size);
		
		return -1;
	}
	private static void hashDelete(int x){
		t[x]=-2; //DELETED 를 의미하는 -2를 저장.
	}
	private static void hashPrint(){
		for(int i=0;i<size;i++){
			if(t[i]==-1){
				System.out.println("index "+i+":null");
			}else if(t[i]==-2){
				System.out.println("index "+i+":DELETED");
			}else{
				System.out.println("index "+i+":"+t[i]);
			}
			
		}
		System.out.println();
	}
}
