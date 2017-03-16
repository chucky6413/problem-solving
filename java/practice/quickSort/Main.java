/*
 * 2017.03.01
 * 퀵소트
 *
 * @github https://github.com/chucky6413
 * @author chucky3
 */
import java.util.*;

class Main{
    public static void main(String[] args){    	
    	int arr[] = {5,4,2,3,1,10,9,8,15};
    	System.out.println(Arrays.toString(arr));
    	quickSort(arr,0,7);
    	System.out.println(Arrays.toString(arr));
    }
    public static void quickSort(int arr[],int left,int right){
    	if(left<right){
    		int p = partition(arr,left,right);
    		quickSort(arr,left,p-1);
    		quickSort(arr,p+1,right);
    	}
    }
    public static int partition(int arr[],int left,int right){
    	int pivot,i,j;
    	pivot = arr[left];
    	i = left;
    	j = right+1;
    	
    	do{
    		while(i<right && arr[++i]<pivot); //왼쪽부터, pivot보다 작으면 i 값 증가
    		while(arr[--j]>pivot); //오른쪽부터, pivot보다 크면 j값 감소
    		if(i<j){ //중간이 남아있으면, 아직 pivot 기준으로 완전히 나눠지지 않은 것.
    			int temp = arr[i]; // 값 바꾸고 다시 위의 반복문 진행함.
    			arr[i] = arr[j];
    			arr[j] = temp;
    		}
    	}while(i<j); //끝나면 pivot 기준으로, 왼쪽에는 작은 값들, 오른쪽에는 큰 값들이 저장되어 있음.
    	    	
    	int temp = arr[left]; //pivot보다 작은애들이, 왼쪽으로 몰렸으므로, 몰린 왼쪽의 맨 끝번째와 pivot을 자리바꿔주고
    	arr[left] = arr[j];   //pivot은 그 자리에 고정된 후, 왼쪽 오른쪽을 다시 분할 정복 할 것 이다.
    	arr[j] = temp; 
    	return j;
    }
}