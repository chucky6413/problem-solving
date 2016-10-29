import java.io.*;
import java.util.Scanner;

public class HeapSort {
	public static void main(String arg[]) throws IOException{
		Scanner fs;
		fs=new Scanner(new File("hw3_7.txt"));
		int num=fs.nextInt()+1;
		int arr[]=new int[num];
		for(int i=1;i<num;i++){
			arr[i]=fs.nextInt();
			System.out.print(arr[i]+" ");
		}
		
		heapsort(arr,num-1);
		
		System.out.println();
		
		for(int i=1;i<num;i++){
			System.out.print(arr[i]+" ");
		}
	}
	public static void buildHeap(int arr[],int num){
		for(int i=(num)/2;i>=1;i--)
			heapify(arr,i,num);
	}
	public static void heapify(int arr[],int i,int num){
		int left=2*i;
		int right=(2*i)+1;
		int small;
		
		if(right<=num){
			if(arr[left]<arr[right])
				small=left;
			else
				small=right;
		}else if(left<=num){
			small=left;
		}else{
			return;
		}
		
		if(arr[i]>arr[small]){
			int temp=arr[small];
			arr[small]=arr[i];
			arr[i]=temp;
			heapify(arr,small,num);
		}
	}
	public static void heapsort(int arr[],int num){
		buildHeap(arr,num);
		
		for(int i=num;i>=2;i--){
			int temp=arr[i];
			arr[i]=arr[1];
			arr[1]=temp;
			heapify(arr,1,i-1);
		}
	}
}
