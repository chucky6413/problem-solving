import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class LunchBox{
    public static void main(String arg[]) throws IOException{
    	
    	int c;
    	int n;	
    	int cookEat[][]; //2차원배열 조리,먹는시간 
    	int totalCook = 0; //고정시간 (총 요리시간)
    	int max = -2147483648; //eating max time
    	int current = 0; //현재까지 먹은 시간
    	int temp = 0;
    	int i=0;
    	
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	Scanner input = new Scanner(System.in);
    	StringTokenizer cook;
    	StringTokenizer eat;
    	
    	c=input.nextInt();
    	for(int k=0;k<c;k++){
	    	n = input.nextInt();
	    	cookEat = new int[2][n];
	    	
	    	cook = new StringTokenizer(in.readLine()," ");
	    	eat = new StringTokenizer(in.readLine()," ");
	    	
	    	
	    	while(cook.hasMoreTokens()){
	    		cookEat[0][i]=Integer.parseInt(cook.nextToken());
	    		totalCook += cookEat[0][i];
	    		i++;
	    	}
	    	i=0;
	    	while(eat.hasMoreTokens()){
	    		cookEat[1][i]=Integer.parseInt(eat.nextToken());
	    		i++;
	    	}
	    	
	    	quickSort(cookEat,0,n-1);
	    	
	    	for(int j=0;j<n;j++){
	    		current+=cookEat[0][j];
	    		temp = cookEat[1][j]-(totalCook-(current));
	    		if(temp>max){
	    			max=temp;
	    		}
	    	}
	    	sb.append(totalCook+max+"\n");
	    	
	    	//초기화
	    	current=0;
	    	max = -2147483648;
	    	i = 0;
    	}
    	input.close();
    	System.out.print(sb.toString().substring(0,sb.length()));
    }
    public static void quickSort(int cookEat[][],int p,int r){
    	int q;
    	if(p<r){
    		q=partition(cookEat,p,r);
    		quickSort(cookEat,p,q-1);
    		quickSort(cookEat,q+1,r);
    	}
    }
    public static int partition(int cookEat[][],int p,int r){
    	int c = cookEat[0][r];
    	int e = cookEat[1][r];
    	int i = p-1;
    	int tempCook = 0;
    	int tempEat = 0;
    	
    	for(int j=p;j<r;j++){
    		if(cookEat[1][j]>=e){
    			++i;
    			tempCook = cookEat[0][i];
    			tempEat = cookEat[1][i];
    			
    			cookEat[0][i] = cookEat[0][j];
    			cookEat[1][i] = cookEat[1][j];
    			
    			cookEat[0][j] = tempCook;
    			cookEat[1][j] = tempEat;
    		}
    	}
    	tempCook = cookEat[0][++i];
		tempEat = cookEat[1][i];
		
		cookEat[0][i] = cookEat[0][r];
		cookEat[1][i] = cookEat[1][r];
		
		cookEat[0][r] = tempCook;
		cookEat[1][r] = tempEat;
    	
    	return i;
    }
}