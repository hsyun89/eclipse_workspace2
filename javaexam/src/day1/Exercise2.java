package day1;

public class Exercise2 {

	public static void main(String[] args) {
		int a=35;
		int b=10;
		
		int x = a/b;
		//int y = a%b;
		int y = a-b*x;
		
		System.out.print(a+"를" +b+"으로 나눈 결과 몫은" + x +"이고");
		System.out.print("나머지는" +y +"입니다");
	}

}
