//***************************
 // 파일명: hw5_4.java
 // 작성자: 이준우
 // 작성일: 2015.10.02
 // 설명: 희소다항식으로 표현한 다항식의 덧셈을 하는 프로그램입니다.
 //        실제 배열은 계수가 0인 행들은 존재하지 않지만 출력시에 조건문을 걸어
//         출력은 계수가 0인것들도 표현해주는 프로그램입니다.
 //***************************

class operatePx{ // 다항식 연산 클래스
	private int degree_A = 0;
	private int degree_B = 0;
	private int degree_C = 0;
	private int index_A = 0;
	private int index_B = 0;
	private int index_C = 0;
	private int expo_A;
	private int expo_B;
	 
	public void Px_To_SpPx(Px C){ //어떤 다항식이던 희소다항식으로 변경해줌.
		int count=0;
		int j=0;
		double temp[][]=new double[20][2];
		for(int i=0;i<=C.coef.length-1;i++)
		{
			if(C.getCoef(i)!=0.0){
				temp[j][1]=C.getCoef(i);
				temp[j][0]=C.getExpo(i);
				count++;
				j++;
			}	
		}
		double SpPx[][]=new double[count][2];

		for(int i=0;i<count;i++)
		{
			SpPx[i][0]=temp[i][0];
			SpPx[i][1]=temp[i][1];
		}
		C.setPx(SpPx);
		C.setDegree((int)(C.getExpo(0)));
	}
	
	public Px add(Px A,Px B) //어떤 다항식이든 지수를 맞춰서 더해줌.
	{
		degree_A = A.getDegree();
		degree_B = B.getDegree();
		expo_A = degree_A;
		expo_B = degree_B;
		
		if(degree_A >= degree_B)
			degree_C = degree_A;
		else
			degree_C = degree_B;
		
		Px C = new Px(degree_C);
		
		while(index_A <= degree_A && index_B <= degree_B)
		{
			if(expo_A > expo_B)
			{
				C.setExpo(index_C,expo_A);
				C.setCoef(index_C++,A.getCoef(index_A++));
				expo_A--;
				expo_B--;
			}
			else if(expo_A==expo_B)
			{
				if(A.getExpo(index_A)==B.getExpo(index_B))
				{
					C.setExpo(index_C,expo_A);
					C.setCoef(index_C++,A.getCoef(index_A++)+B.getCoef(index_B++));
					expo_B--;
					expo_A--;
				}
				else if(A.getExpo(index_A)>B.getExpo(index_B))
				{
					C.setExpo(index_C,expo_A);
					C.setCoef(index_C++,A.getCoef(index_A++));
					expo_A--;
					expo_B--;
				}
				else
				{	
					C.setExpo(index_C,expo_B);
					C.setCoef(index_C++,B.getCoef(index_B++));
					expo_B--;
				}	
			}	
			else
			{
				C.setExpo(index_C,expo_B);
				C.setCoef(index_C++,B.getCoef(index_B++));
				expo_B--;				
			}
		}
		return C;
	}

	
	
}

class Px{ //다항식 클래스.
	int degree;
	double coef[][]=new double[20][2];
	
	public Px(int degree,double coef[][]){
		this.degree=degree;
		this.coef=coef;
	}
	public Px(int degree)
	{
		this.degree = degree;
		for(int i=0;i<=degree;i++)
			for(int j=0;j<2;j++)
				coef[i][j]=0;
	}
	public void setPx(double Px[][]){
		coef=Px;
	}
	public int getDegree(){
		return degree;
	}
	public void setDegree(int degree){
		this.degree=degree;
	}
	public double getCoef(int expo){
		if(expo<coef.length)
			return coef[expo][1];
		else
			return 0;
	}
	public double getExpo(int index){
		if(index<coef.length)
			return coef[index][0];
		else
			return -1;
	}
	public void setCoef(int expo,double value){
		this.coef[expo][1]=value;
	}
	public void setExpo(int index,double expo){
		this.coef[index][0]=expo;
	}
	public void spPxPrint(String s){ //실제 배열의 저장 구조를 볼 수 있게 출력해주는 메소드
		int j=0;
		System.out.print(s+"=");
		for(int i=0;i<=coef.length-1;i++)
		{	j=0;
			System.out.println("("+coef[i][j++]+","+coef[i][j]+")");
		}
	}
	public void valuePrint(String s){  //배열의 계수를 출력해주지만 조건문을 통해 계수가 없는 지수의 항은 0.0으로 출력해줌.
		int j=0;
		System.out.print(s+"=");
		
		if(coef.length>degree){ //렝스가 지수보다 클 경우에는 그냥 출력한다.
		for(int i=0;i<=coef.length-1;i++)
			System.out.print(coef[i][1]+" ");
		}
		else if(coef.length==degree){//0인 계수를 갖는 생성되지 않은 지수를 구하여 0으로 출력해주기 위한 문장들.
			j=degree;
			for(int i=degree;i>=0;i--){
				if(i==getExpo(degree-j)){
					System.out.print(coef[degree-j][1]+" ");
					j--;
				}
				else
					System.out.print(0.0+" "); //실제 계수를 갖고있지않는..배열에 존재하지 않는행을 찾아서 0으로 출력해준다.
			}
			
		}
		
		System.out.println();
	}
}
public class hw5_4 {
	public static void main(String arg[]){
		System.out.println("hw5_4:이준우\n");
		
		double A1[][]={{3,9},{2,3},{1,5}};
		double B1[][]={{4,8},{3,1},{2,-3},{1,2.5},{0,1.8}};
		double A2[][]={{4,3},{3,4},{2,5},{1,6},{0,7}};
		double B2[][]={{4,-3},{3,-4},{2,4},{1,6}};
		double A3[][]={{6,7},{5,-6},{4,5},{3,4},{2,3},{1,1.5},{0,2.5}};
		double B3[][]={{6,6},{5,3},{4,2},{3,1},{1,7},{0,8}};
		
		Px a1=new Px(3,A1);
		Px b1=new Px(4,B1);
		Px a2=new Px(4,A2);
		Px b2=new Px(4,B2);
		Px a3=new Px(6,A3);
		Px b3=new Px(6,B3);
		
		operatePx opsa1=new operatePx();
		operatePx opsa2=new operatePx();
		operatePx opsa3=new operatePx();
		
		Px c1=opsa1.add(a1,b1);
		opsa1.Px_To_SpPx(c1); //다항식을 희소다항식으로 변경해준다.
		c1.valuePrint("C1");
		//c1.spPxPrint("C1");  //이문장은 실제 배열의 저장상태를 보여주며 계수가 배열의
		                       //실제 원소들을 볼수 있는 문장입니다. 계수가 0인 배열의 행들은 존재하지 않지만
		                       //valuePrint 로 출력할시 존재하지않지만 건너뛴 사이의 계수를 0.0으로 출력해주게끔 했습니다.
		Px c2=opsa2.add(a2,b2);
		opsa2.Px_To_SpPx(c2); //다항식을 희소다항식으로 변경해준다.
		c2.valuePrint("C2");
		//c2.spPxPrint("C2"); 
		
		Px c3=opsa3.add(a3,b3);
		opsa3.Px_To_SpPx(c3); //다항식을 희소다항식으로 변경해준다.
		c3.valuePrint("C3");
		//c3.spPxPrint("C3"); 
	}
}
