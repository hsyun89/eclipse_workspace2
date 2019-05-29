package day3;

public class ArrayTest3 {

	public static void main(String[] args) {
		int[] nums = new int[5];
		System.out.println(nums);
		for(int i=0; i<nums.length; i++)
			System.out.print(nums[i]+" ");
		System.out.println();

		for(int data : nums )
			System.out.print(data+" ");
		System.out.println();

		double[] su = new double[3];
		System.out.println(su);
		for (int i = 0; i < su.length; i++)
			System.out.print(su[i] + " ");
		System.out.println();
		for (double data : su)
			System.out.print(data + " ");
		System.out.println();

		boolean flag[] = new boolean[8];
		System.out.println(flag);
		for(int i=0; i<flag.length; i++)
			System.out.print(flag[i]+" ");
		System.out.println();
		for (boolean data : flag)
			System.out.print(data + " ");
		System.out.println();
	}

}
