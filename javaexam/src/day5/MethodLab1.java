package day5;

public class MethodLab1 {

	public static void main(String[] args) {
		printCha('@', 3);
		System.out.println();
		printCha('%', 4);
		System.out.println();
		printCha('A', 5);
		System.out.println();
		printCha('°¡', 3);
		System.out.println();
	}

	static void printCha(char cha1, int num) {
		for (int i = 0; i < num; i++) {
			System.out.print(cha1);
		}
	}
}
