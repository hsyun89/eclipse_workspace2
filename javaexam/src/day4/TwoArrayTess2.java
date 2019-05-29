package day4;

public class TwoArrayTess2 {

	public static void main(String[] args) {
		int nums[][] = {
				{10,20,30,40}
			,	{11,21,31,41}
			,	{12,22,32,42}
			,	{13,23,33,43}
		};
		
//		//2행 3열의 데이터를 출력해 본다.
//		System.out.println(nums[1][2]);
//		
//		//3행만 출력
//		final int hang=3;  //3행
//		for(int i=0;i<nums[hang-1].length;i++)
//			System.out.println(nums[hang-1][i]);
//		
//		for(int data:nums[2])
//			System.out.println(data);
//		
//		//4열만 출력
//		final int yul=4; //4행
//		for(int i=0;i<nums[yul-1].length;i++)
//			System.out.println(nums[i][yul-1]);
		
		//왼쪽 대각선에 해당하는 데이터만 출력한다. for문
//		for(int i=0; i<nums[0].length; i++)
//			System.out.println(nums[i][i]);
		
		//오른쪽 대각선에 해당하는 데이터만 출력한다. for문
		for(int i=0; i<nums[0].length; i++)
		System.out.println(nums[i][3-i]);

	}
}
