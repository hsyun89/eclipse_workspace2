package day5;

public class MethodTest3 {

	public static void main(String[] args) {
		System.out.println("main() 수행시작");
		printMyName(1,'*');
		System.out.println(1);
		printMyName(2,'@');
		System.out.println(2);
		printMyName(3,'#');
		System.out.println(3);
		System.out.println("main() 수행종료");
	}

	static void printMyName(int num, char deco) {
		for (int i = 1; i <= num; i++)
			System.out.println(deco + "유니코"+deco);
	}

}
