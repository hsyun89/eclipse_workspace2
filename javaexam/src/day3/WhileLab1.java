package day3;

public class WhileLab1 {

	public static void main(String[] args) {
		int num = (int) (Math.random() * 6) + 5;

//		for문
		System.out.println("[for 결과]");
		for (int i = 1; i <= num; i++)
			System.out.println(i + " -> " + i * i);

//		while문
		System.out.println("[while 결과]");
		int k = 1;
		while (k <= num) {
			System.out.println(k + " -> " + k * k);
			k++;
		}
	}
}
