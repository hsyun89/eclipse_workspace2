package day6;

import java.util.Scanner;

public class ScannerLab3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int result = 0;
		
		//입력된 숫자가 둘 중에 하나라도 0 이하면
		//"양의 값만 입력하세요!!"라는 메시지를 출력하고
		//첫 번째 숫자부터 다시 입력받게 한다.
		int num1=0;
		int num2=0;
		//continue를 사용하기~~~~~~~~
		while(true) {
			System.out.print("첫 번째 숫자를 입력하세요 : ");
			num1 = sc.nextInt();
			System.out.print("두 번째 숫자를 입력하세요 : ");
			num2 = sc.nextInt();
			if(num1<=0 || num2<=0) {
				System.out.println("양의 값만 입력하세요!!");	
				continue;
			}
			else
				break;
		}
		System.out.print("연산자(+, -, *, /)를 입력하세요 :  ");
		String cal = sc.next();
		sc.close();
		

		switch (cal) {
		case "+":
			result = num1 + num2;
			break;
		case "-":
			result = num1 - num2;
			break;
		case "/":
			result = num1 / num2;
			break;
		case "*":
			result = num1 * num2;
			break;
		}
		System.out.printf("%d와 %d의 %s연산 결과는 %d입니다 ", num1, num2, cal, result);

	}

}
