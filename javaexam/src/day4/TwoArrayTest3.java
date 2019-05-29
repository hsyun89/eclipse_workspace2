package day4;

public class TwoArrayTest3 {
	public static void main(String[] args) {
		char[][] ary = new char[3][8];
//		ary[0] = new char[8];
//		ary[1] = new char[4];
//		ary[2] = new char[10];
//		System.out.println(ary.length);
//		System.out.println(ary[0].length);
//		System.out.println(ary[1].length);
//		System.out.println(ary[2].length);
		char lowerAlpha = 'a';
		for (int i = 0; i < ary.length; i++) {
			for (int j = 0; j < ary[i].length; j++) {
				ary[i][j] = lowerAlpha++;
				System.out.printf("%c   ", ary[i][j]);
			}
			System.out.println();
		}
		for (int i = 0; i < ary.length; i++) {
			for (int j = 0; j < ary[i].length; j++) {

				System.out.printf("%c   ", ary[i][j] - 32);
			}
			System.out.println();
		}
	}
}
