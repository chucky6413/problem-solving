import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner input = new Scanner(System.in);
    	int dart[] = {6,13,4,18,1,20,5,12,9,14,11,8,16,7,19,3,17,2,15,10};
    	
    	int t = input.nextInt(); //test case
    	
    	for(int i=1;i<=t;i++){
    		int a = input.nextInt(); //bull의 반지름
    		int b = input.nextInt(); //triple 시작
    		int c = input.nextInt(); //triple 끝
    		int d = input.nextInt(); //double 시작
    		int e = input.nextInt(); //double 끝
    		
    		int n = input.nextInt(); //다트 던진 횟수
    		int score = 0;
    		for(int j=0;j<n;j++){
    			int x = input.nextInt(); //던진 다트의 x좌표
    			int y = input.nextInt(); //던진 다트의 y좌표
    			
    			double len = Math.sqrt((x*x)+(y*y));
    			if(len<a){ //bull 안에 들어갈 경우
    				score+=50;
    				continue;
    			}else if(len>e){ //점수를 받지 못할 경우
    				continue;
    			}
    			
    			int m = 1; //기본으로 single 점수
    			if(len>b && len<c){
    				m=3; //triple 3배
    			}else if(len>d && len<e){
    				m=2; //double 2배
    			}
    			
    			double theta = Math.atan((double)y/x);
    			System.out.println(theta);
    			theta*=(180/Math.PI);
    			theta+=9; //만일 9도일 경우.. 0번째가 아닌 1번째의 score를 얻어야 하므로 ..18로 나눴을때.. 9를 더해줘야 한다.
    			if(x<0) //음수일 경우
    				theta+=180;
    			System.out.println(theta);
    			theta = (theta+360)%360;
    			System.out.println(theta);
    			int spot = (int)(theta/18);
    			score += m*dart[spot];
    			System.out.println(spot);
    		}
    		System.out.println("Case #" + i);
    		System.out.println(score);
    	}
    }
}
