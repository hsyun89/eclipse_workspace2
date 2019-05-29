package day2;

public class ForLab2 {
	public static void main(String[] args) {
		int firstRan = (int) (Math.random() * 8) + 3;
		int secondRan = (int) (Math.random() * 3) + 1;
		switch (secondRan) {
		case 1:
			for (int i = 1; i <= firstRan; i++)
				System.out.print("*");
			break;
		case 2:
			for (int i = 1; i <= firstRan; i++)
				System.out.print("$");
			break;
		case 3:
			for (int i = 1; i <= firstRan; i++)
				System.out.print("#");
		}
	}
}
