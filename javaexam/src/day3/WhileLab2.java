package day3;

public class WhileLab2 {
	public static void main(String[] args) {
		int count = 0;
		while (true) {
			int num = (int) (Math.random() * 31); // 0~30난수
			if (1 <= num && num <= 26) {
				System.out.printf("%c(%d)\n", num + 64, num); // 1+64=65, char65='A'이므로
				count++;
			} else
				break;
		}
		System.out.println("수행횟수는 " + count + " 번입니다");
	}
}