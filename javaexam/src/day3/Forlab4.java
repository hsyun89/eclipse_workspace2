package day3;

public class Forlab4 {
	public static void main(String[] arg) {
		final char star = '*';

		for (int i = 1; i <= 7; i++) {
			for (int j = 7; j >= i; j--) {
				System.out.print(star);
			}
			System.out.println();
		}
	}
}
