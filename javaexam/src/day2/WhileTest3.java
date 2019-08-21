package day2;

public class WhileTest3 {

	public static void main(String[] args) {
//		System.out.println("main() 수행 시작");
		System.out.printf("main() 수행 시작\n");
		char munja = '가';
		while(munja<'나') {
//			System.out.println(munja);
//			System.out.printf("%c\n", munja);
			System.out.printf("%c  %d  %#x\n",munja, (int)munja, (int)munja);
			munja++;
		}
//		System.out.println("main() 수행 종료");
		System.out.printf("main() 수행 종료\n");
	}
}
