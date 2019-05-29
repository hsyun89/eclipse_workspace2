package day5;

public class MethodLab5 {

	public static void main(String[] args) {
		int r1[] = powerArray(2);
		int r2[] = powerArray(3);
		int r3[] = powerArray(4);
		printArray(r1);
		System.out.println();
		printArray(r2);
		System.out.println();
		printArray(r3);
	}

	// 배열 곱하기
	static int[] powerArray(int times) {
		int[] nums = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		for (int i = 0; i < nums.length; i++)
			nums[i] = nums[i] * times;
		return nums;
	}
	// 배열 출력 메서드
	static void printArray(int[] number) {
		for (int i = 0; i < number.length; i++)
			if (i == 0)
				System.out.print(number[i]);
			else
				System.out.print(", " + number[i]);
	}

}
