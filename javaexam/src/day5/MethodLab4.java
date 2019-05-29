package day5;

public class MethodLab4 {

	public static void main(String[] args) {
		int[] nums1 = new int[] { 10, 20, 30 };
		int[] nums2 = new int[] { 100, 500, 300, 200, 400 };
		int[] nums3 = new int[] { 1, 10, 3, 4, 5, 8, 7, 6, 9, 2 };

		System.out.println("가장 큰 값은 " + maxNumArray(nums1) + " 입니다.");
		System.out.println("가장 큰 값은 " + maxNumArray(nums2) + " 입니다.");
		System.out.println("가장 큰 값은 " + maxNumArray(nums3) + " 입니다.");

	}

	// 맥스함수
	static int maxNumArray(int[] jumsu) {
		int maxNumber = 0;
		for (int i = 0; i < jumsu.length; i++) {
			if (i == 0)
				maxNumber = jumsu[i];
			if ((i > 0) && (jumsu[i] > maxNumber))
				maxNumber = jumsu[i];
		}
		return maxNumber;
	}
}
