package day2;

public class ForLab3 {
	public static void main(String[] args) {

		char aa = '&';
		int ran = (int) (Math.random() * 6) + 5;
		for (int i = 1; i <= ran; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(aa);
			}
			System.out.println();
		}
//		if (ran == 5) {
//			for (int i = 1; i <= ran; i++) {
//				for (int j = 1; j <= i; j++) {
//					System.out.print(aa);
//				}
//				System.out.println();
//			}
//		}
//		if (ran == 7) {
//			for (int i = 1; i <= ran; i++) {
//				for (int j = 1; j <= i; j++) {
//					System.out.print(aa);
//				}
//				System.out.println();
//			}
//		}
	}
}
