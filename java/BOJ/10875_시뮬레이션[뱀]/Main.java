/*
 * 2017.04.13
 * 시뮬레이션
 * 
 * @problem https://www.acmicpc.net/problem/10875
 * @github https://github.com/chucky6413
 * @author chucky3
 */
import java.util.*;
import java.io.*;

public class Main{
	static int L,N;
	static List<Line> lineList = new LinkedList<Line>();
	static List<Rotate> rotateList = new LinkedList<Rotate>();
	static final int DIR_X[] = {0,-1,0,1}; // 0 - 위 / 1 - 왼쪽 / 2 - 아래 / 3 - 오른쪽
	static final int DIR_Y[] = {1,0,-1,0}; //반시계 방향
	public static void main(String arg[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp[];
		L = Integer.parseInt(br.readLine());
		N = Integer.parseInt(br.readLine());
		
		for(int i=0;i<N;i++){
			temp = br.readLine().split(" ");
			rotateList.add(new Rotate(Integer.parseInt(temp[0]),temp[1].charAt(0)));
		}
		
		//테두리를 선분으로 저장해 놓는다.
		lineList.add(new Line(-L-1, -L-1, L+1, -L-1));
		lineList.add(new Line(-L-1, -L-1, -L-1, L+1));
		lineList.add(new Line(-L-1,L+1,L+1,L+1));
		lineList.add(new Line(L+1, -L-1, L+1, L+1));
		
		int x=0, y=0, dir=3; //뱀 머리 x,y 좌표. 이동 방향
		long answer = 0; //결과
		
		for(int i=0;i<=N;i++){
			int min = 1000000001;
			for(int j=0;j<lineList.size();j++){ //모든 선분 중 만날 수 있는 가장 가까운 선분을 검사한다.
				min = Math.min(min, cross(dir,x,y,lineList.get(j)));
			}
			
			if(i==N || min<=rotateList.get(i).time){ //닿을 수 있는 거리만큼 뱀이 커진다면
				answer+=min; //그 거리만큼 시간 추가.
				break; //종료
			}
			
			answer+=rotateList.get(i).time; //시간 추가
			int mx = x+DIR_X[dir]*rotateList.get(i).time; //현재 위치 + 방향 * 움직인 시간
			int my = y+DIR_Y[dir]*rotateList.get(i).time;
			// 0 - 위 / 1 - 왼쪽 / 2 - 아래 / 3 - 오른쪽
			//아래로 가던 중 왼쪽 2 -> 3 이 되어야 함. 2+(1)+4 %4 -> 3
			//아래로 가던 중 오른쪽 2->1 이 되어야 함. 2+(-1)+4 % 4 -> 1  방향 전환 규칙.
			dir=(dir+rotateList.get(i).dir+4)%4; //방향 변경
			lineList.add(new Line(x,y,mx,my)); //시작점(x,y) 도착점(mx,my)
			x=mx; //머리 위치 변경
			y=my; //머리 위치 변경
		}
		System.out.println(answer);
	}
	/*
	 * dir : 진행 방향 , x,y 지금 출발할 위치
	 * line : 검사할 선분
	 * 진행방향으로의 선분과, 검사할 선분이 닿는다면 닿기 전까지의 거리를 반환한다.
	 * 만일 선분과 선분이 만나지 않는다면, default 값을 반환한다.
	 */
	public static int cross(int dir,int x,int y,Line line){
		int gap = 1000000001;
		if(line.dir==0){ //수직일 때,
			if(dir==0){ //위로 올라갈 껀데
				if(x==line.x1 && y<line.y1){ //x점 같고, 내가 아래서 시작하면
					gap = Math.min(gap, line.y1-y);
				}
			}else if(dir==1){ //왼쪽으로 갈껀데
				if(line.y1<=y&&y<=line.y2&&line.x1<x){
					gap = Math.min(gap,x-line.x1);
				}
			}else if(dir==2){ //아래로 갈껀데
				if(x==line.x1 && line.y2<y){
					gap = Math.min(gap, y-line.y2);
				}
			}else{
				if(line.y1<=y&&y<=line.y2&&x<line.x1){
					gap = Math.min(gap, line.x1-x);
				}
			}
		}else{ //수평일 때
			if(dir==0){
				if(line.x1<=x&&x<=line.x2&&y<line.y1){
					gap = Math.min(gap, line.y1-y);
				}
			}else if(dir==1){
				if(line.y1==y&&line.x2<x){
					gap = Math.min(gap, x-line.x2);
				}
			}else if(dir==2){
				if(line.x1<=x&&x<=line.x2&&line.y1<y){ //아래로 갈때
					gap = Math.min(gap, y-line.y1);
				}
			}else{
				if(line.y1==y&&x<line.x1){
					gap = Math.min(gap, line.x1-x);
				}
			}
		}
		return gap;
	}
}
class Rotate{ //회전 규칙
	int time;
	int dir;
	public Rotate(int time, char L){
		this.time = time;
		if(L=='L') //왼쪽이면 1, 오른쪽이면 -1
			dir=1;
		else
			dir=-1;
	}
}
class Line{ //선분
	int x1, y1, x2, y2; // (x1,y1) , (x2,y2) 두 점.
	int dir; // 0 or 1  수평,수직
	
	public Line(int x1, int y1, int x2, int y2){
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		
		if(x1==x2){ //수평
			dir=0;
		}else{
			dir=1;
		}
		swapPoint();
	}
	void swapPoint(){ // x2, y2를 큰것으로 지정.
		if(x1>x2){
			int temp = x1;
			x1 = x2;
			x2 = temp;
		}
		
		if(y1>y2){
			int temp = y1;
			y1 = y2;
			y2 = temp;
		}	
	}
}