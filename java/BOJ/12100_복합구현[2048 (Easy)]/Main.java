/*
 * 2017.04.20
 * 복합구현
 * 
 * @problem https://www.acmicpc.net/problem/12100
 * @github https://github.com/chucky6413
 * @author chucky3
 */
import java.util.*;
import java.io.*;

public class Main{
	static int n,max=0;
	static Block arr[][];
	static Stack<Block> stack = new Stack<Block>();
	public static void main(String arg[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp[];
		
		n = Integer.parseInt(br.readLine());
		arr = new Block[n][n];
		
		for(int i=0;i<n;i++){
			temp = br.readLine().split(" ");
			for(int j=0;j<n;j++){
				int num=Integer.parseInt(temp[j]);
				if(num==0){
					arr[i][j] = null;
				}else{
					arr[i][j] = new Block(num,true);
					max = Math.max(num, max);
				}
			}
		}
		recur(0);
		System.out.println(max);
	}
	public static Block[][] fill(Block[][] origin,Block[][] copy){
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				origin[i][j] = new Block();
				if(copy[i][j]!=null)
					origin[i][j].value = copy[i][j].value;
				else
					origin[i][j] = null;
			}
		}
		return origin;
	}
	public static void recur(int cnt){
		if(cnt==5){
			return;
		}

		Block origin[][] = new Block[n][n];
		origin = fill(origin,arr);
		for(int k=1;k<=4;k++){
			move(k);
			recur(cnt+1);
			arr = fill(arr,origin);
		}
	}
	public static void move(int dir){
		if(dir==1){ //왼쪽
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++)
					sol(i,j);
				while(!stack.isEmpty())
					arr[i][stack.size()-1] = stack.pop();
			}
		}else if(dir==2){
			for(int i=0;i<n;i++){
				for(int j=n-1;j>=0;j--)
					sol(i,j);
				while(!stack.isEmpty())
					arr[i][n-(stack.size())] = stack.pop();
			}
		}else if(dir==3){ //위
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++)
					sol(j,i);
				while(!stack.isEmpty())
					arr[stack.size()-1][i] = stack.pop();
			}
		}else if(dir==4){ //아래
			for(int i=0;i<n;i++){
				for(int j=n-1;j>=0;j--)
					sol(j,i);
				while(!stack.isEmpty())
					arr[n-(stack.size())][i] = stack.pop(); 
			}
		}
	}
	public static void sol(int i,int j){
		if(arr[i][j]!=null)
			arr[i][j].merge=true;
		if(arr[i][j]!=null && stack.isEmpty()){
			stack.push(arr[i][j]);
		}else if(arr[i][j]!=null){
			Block b = stack.peek();
			if(poss(b,arr[i][j])){
				b = stack.pop();
				b.value*=2;
				b.merge=false;
				stack.push(b);
				max = Math.max(b.value, max);
			}else{
				stack.push(arr[i][j]);
			}
		}
		arr[i][j] = null;
	}
	public static boolean poss(Block b1,Block b2){
		if(b1.merge && b2.merge){
			if(b1.value == b2.value){
				return true;
			}
		}
		return false;
	}
}
class Block{
	int value;
	boolean merge;
	public Block(int value,boolean merge){
		this.value = value;
		this.merge = merge;
	}
	public Block(){
		this.merge = true;
	}
}