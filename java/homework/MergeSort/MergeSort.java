//***************************
// 파일명: MergeSort.java
// 작성자: 이준우
// 작성일: 2016/03/27
// 프로그램 설명: 회원정보를 merge sort 를 이용하여 정렬하는 프로그램 입니다.
//***************************
import java.util.Scanner;
import java.io.*;

class People{
	private int id;
	private int point;
	
	public People(int id,int point){
		this.id=id;
		this.point=point;
	}
	public int getId(){
		return this.id;
	}
	public int getPoint(){
		return this.point;
	}
	public void setId(int id){
		this.id=id;
	}
	public void setPoint(int point){
		this.point=point;
	}
}
public class MergeSort {
	public static void main(String arg[]) throws FileNotFoundException{
		int num,id,point;
		Scanner fs;
	
		System.out.println("hw3_4 : 이준우\n");
		fs = new Scanner(new File("hw3_4.txt"));
		num=Integer.parseInt(fs.next());
		People array[]=new People[num];
		
		System.out.print("병합 전 : ");
		for(int i=0;i<num;i++){
			id=Integer.parseInt(fs.next());
			point=Integer.parseInt(fs.next());
			array[i]=new People(id,point);
			System.out.print(id+" "+point+"  ");
		}
		System.out.println();
		
		mergeSort(array,0,num-1);
		
		System.out.print("병합 후 : ");
		for(int i=0;i<num;i++){
			System.out.print(array[i].getId()+" "+array[i].getPoint()+"  ");
		}
		System.out.println();
		
	}
	public static void mergeSort(People array[],int p,int r){
		if(p<r){
			int q=(p+r)/2;
			mergeSort(array,p,q);
			mergeSort(array,q+1,r);
			merge(array,p,q,r);
		}
	}
	public static void merge(People array[],int p,int q,int r){
		People temp[]=new People[r+1];
		int i=p;
		int j=q+1;
		int t=i;
		while(i<=q && j<=r){
			if(array[i].getPoint()<=array[j].getPoint()){
				temp[t++]=new People(array[i].getId(),array[i].getPoint());
				i++;
			}else{
				temp[t++]=new People(array[j].getId(),array[j].getPoint());
				j++;
			}
		}
		
		while(i<=q){
			temp[t++]=new People(array[i].getId(),array[i].getPoint());
			i++;
		}
		while(j<=r){
			temp[t++]=new People(array[j].getId(),array[j].getPoint());
			j++;
		}
		i=p;
		j=r;
		while(i<=j){
			array[i].setId(temp[i].getId());
			array[i].setPoint(temp[i++].getPoint());
		}
	}
}
