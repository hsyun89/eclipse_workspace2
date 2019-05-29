package day6;

import java.util.Scanner;

public class ScannerLab1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int result = 0;
		System.out.print("첫 번째 숫자를 입력하세요 : ");
		int num1 = sc.nextInt();
		System.out.print("두 번째 숫자를 입력하세요 : ");
		int num2 = sc.nextInt();
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
