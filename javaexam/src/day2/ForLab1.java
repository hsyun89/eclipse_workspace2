package day2;

public class ForLab1 {
	public static void main(String[] args) {
		int evenNum = 0;
		int oddNum = 0;

		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 1)
				oddNum += i;
			else
				evenNum += i;
		}
		System.out.println("1부터 100까지의 숫자들 중에서");
		System.out.println("짝수의 합은" + evenNum +" 이고\n" + "홀수의 합은" + oddNum+" 이다.");
	}
}
