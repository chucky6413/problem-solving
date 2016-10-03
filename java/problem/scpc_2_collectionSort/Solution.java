import java.util.Scanner;
import java.util.Arrays;

public class Solution{
	public static void main(String[] arg){
		Scanner input = new Scanner(System.in);
		int t = input.nextInt(); //test case ¼ö
		
		for(int i=1;i<=t;i++){
			int n = input.nextInt();
			int max = 0;
			int count = 0;
			int arr[] = new int[n];
			
			for(int j=0;j<n;j++){
				arr[j] = input.nextInt();
			}
			Arrays.sort(arr);
			int bestCase[] = new int[n];
			for(int j=0;j<n;j++){
				bestCase[j] = arr[j]+n-j;
				if(bestCase[j]>max)
					max = bestCase[j];
			}

			for(int j=0;j<n;j++){
				if(arr[j]+n>=max)
					count++;
			}
			
			System.out.println("Case #" + i);
			System.out.println(count);
		}
	}
}