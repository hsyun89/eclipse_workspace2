package gunsuyul;

public class Gunsu {

	public static void main(String[] args) {
		System.out.println(gun(1)); // 몇번째 값은?
		System.out.println(gun(2));
		System.out.println(gun(3));
		System.out.println(gun(4));
		System.out.println(gun(5));
		System.out.println(gun(6));
	}

	public static int gun(int num) {
		int result = 0;
		int idx = 0;
		int i = 0;
		for (i = 1; idx < num; i++) {
			idx += i;
		}
		result = num - (idx - (i - 1));
		return result;
	}
//	public static int gun(int num) {
//		int result = 0;
//		int idx = 0;
//		int i = 1;
//		while (idx < num) {
//			idx += i;
//			i++;
//		}
//		result = num-(idx-(i-1));
//		return result;
//	}
}
