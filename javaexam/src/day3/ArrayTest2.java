package day3;

public class ArrayTest2 {

	public static void main(String[] args) {

		int[] nums = new int[10];
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println();

		int[] nums2 = new int[] { 10, 20, 30, 40, 50 };
		for (int i = 0; i < nums2.length; i++) {
			System.out.print(nums2[i] + " ");
		}
		System.out.println();

		for (int i = nums2.length-1; i >=0; i--) {
			System.out.print(nums2[i] + " ");
		}
		System.out.println();
		
		// nums2 참조하는 배열의 첫 번째 데이터값하고
		// 마지막 데이터값을 덧셈하여 출력해 본다.
		System.out.println(nums2[0]+nums2[4]);
		// nums2 참조하는 배열의 첫번째, 세번째, 다섯번째 데이터를
		// 출력하는 for문을 작성해 본다.
		for(int i=0; i<nums2.length; i+=2) 
			System.out.print(nums2[i] + " ");
		System.out.println();
	
		
		int[] nums3 = { 100, 200, 300 };
		for (int i = 0; i < nums3.length; i++) {
			System.out.print(nums3[i] + " ");
		}
		System.out.println();
	}
}
