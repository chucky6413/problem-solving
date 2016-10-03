import java.util.Scanner;
import java.util.Arrays;

public class Main{
	public static void main(String[] arg){
		Scanner input = new Scanner(System.in);
		int t = input.nextInt(); //test case ¼ö
		
		for(int i=1;i<=t;i++){
			int result = 0;
			int n = input.nextInt();
			int k = input.nextInt();
			
			int arr[] = new int[n];
			for(int j=0;j<n;j++){
				arr[j] = input.nextInt();
			}
			
			Arrays.sort(arr);
			for(int j=0;j<k;j++){
				result += arr[n-1-j];
			}
			
			System.out.println("Case #" + i);
			System.out.println(result);
		}
	}
}