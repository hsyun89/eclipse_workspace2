package day5;

public class MethodTest6 {

	public static void main(String[] args) {
		System.out.println(add(10, 100));
		System.out.println(add(add(10, 100), 1000));
		System.out.println(add(10, 100, 1000));
		System.out.println(addArray(new int[] { 10, 20, 30, 40, 50, 60 }));
		int nums[] = { 1, 2, 3, 4, 5 };
		System.out.println(addArray(nums));
		System.out.println(add(1,2,3,4,5));
		System.out.println(add(1,2,3,4,5,6,7,8,9,10));
		System.out.println(add());
	}

//	static int add(int p1, int p2) {
//		return p1 + p2;
//	}
//
//	static int add(int p1, int p2, int p3) {
//		return p1 + p2 + p3;
//	}
	// 여러개 전달하려는 경우2
	// 가변 인자(Java 5 버전부터 추가)
	static int add(int... p) {
		int result = 0;
		for (int data : p)
			result += data;
		return result;
	}
	// 여러개 전달하려는 경우1
	static int addArray(int[] p) {
		int result = 0;
		for (int data : p)
			result += data;
		return result;
	}

}
