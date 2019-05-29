package day2;

public class ForTest4 {
	public static void main(String[] args) {
		unico: for (int dan = 1; dan <= 9; dan++) {
			for (int num = 1; num <= 9; num++) {
				if (dan * num > 30)
					break unico;
//				System.out.print(dan + "x" + num + "=" + dan * num + "\t");
				System.out.printf("%d x %d = %d\t", dan, num, dan * num);
			}
//			System.out.println();
			System.out.printf("\n");
		}
	}
}
