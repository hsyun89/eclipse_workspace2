package day5;

//import java.util.Scanner;

public class MethodLab2 {

	public static void main(String[] args) {
		//스캐너
//		Scanner sc = new Scanner(System.in);
//		int x = sc.nextInt();
//		int y = sc.nextInt();
//		System.out.printf("%d와 %d의 차는 %d입니다.",x,y,calMinus(x,y));
		for (int i = 0; i < 5; i++) {
			int x = (int) (Math.random() * 30) + 1;
			int y = (int) (Math.random() * 30) + 1;
			System.out.printf("%d와 %d의 차는 %d입니다.\n", x, y, calMinus(x, y));
		}
	}

	static int calMinus(int num1, int num2) {
		int result;
		result = num1 - num2;
		if (result < 0)
			result *= -1;
		return result;
	}
}
