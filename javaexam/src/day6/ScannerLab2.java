package day6;

import java.util.Scanner;

public class ScannerLab2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int result = 0;

		// �Էµ� ���ڰ� �� �߿� �ϳ��� 0 ���ϸ�
		// "���� ���� �Է��ϼ���!!"��� �޽����� ����ϰ�
		// ù ��° ���ں��� �ٽ� �Է¹ް� �Ѵ�.
		int num1 = 0;
		int num2 = 0;
		// for�� i�� ����ϱ�!!!!!!!!!!!!!!
		for (int i = 0; i < 1; i++) {
			System.out.print("ù ��° ���ڸ� �Է��ϼ��� : ");
			num1 = sc.nextInt();
			System.out.print("�� ��° ���ڸ� �Է��ϼ��� : ");
			num2 = sc.nextInt();
			if (num1 <= 0 || num2 <= 0) {
				i = -1;
				System.out.println("���� ���� �Է��ϼ���!!");
			}
		}
		System.out.print("������(+, -, *, /)�� �Է��ϼ��� :  ");
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
		System.out.printf("%d�� %d�� %s���� ����� %d�Դϴ� ", num1, num2, cal, result);

	}

}