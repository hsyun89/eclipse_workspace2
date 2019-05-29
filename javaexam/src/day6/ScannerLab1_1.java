package day6;

import java.util.Scanner;

public class ScannerLab1_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int result = 0;
		
		System.out.print("첫 번째 숫자를 입력하세요 : ");
		String snum1 = sc.nextLine();
		System.out.print("두 번째 숫자를 입력하세요 : ");
		String snum2 = sc.nextLine();
		System.out.print("연산자(+, -, *, /)를 입력하세요 :  ");
		String cal = sc.nextLine();
		sc.close();
		
		int num1=Integer.parseInt(snum1);
		int num2=Integer.parseInt(snum2);

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
