package day3;

public class ArrayTest4 {

	public static void main(String[] args) {
		int[] ary = new int[8];
		int sum = 0;
		for (int data : ary)
			sum += data; // sum = sum + data;
		System.out.println("sum" + sum);

//		ary[0] = 11;
//		ary[1] = 12;
//		ary[2] = 13;
//		ary[3] = 14;
//		ary[4] = 15;

		for (int i = 0; i < ary.length; i++)
			ary[i] = 11 + i;

		for (int data : ary)
			sum += data; // sum = sum + data;
		System.out.println("sum" + sum);

//ary 배열의 각 원소값을 각각 두 배로 수정한다.
//		for (int i = 0; i < ary.length; i++)
//			ary[i] = ary[i] * 2;
//		for (int i = 0; i < ary.length - 1; i++) {
//			System.out.print(ary[i] + ", ");
//		}
//		System.out.print(ary[ary.length - 1]);
//모든 원소값을 출력한다. ex) x, x, x, x, x

		for (int i = 0; i < ary.length; i++) {
			ary[i] *= 2;
			if (i == ary.length - 1)
				System.out.print(ary[i]);
			else
				System.out.print(ary[i] + ", ");
		}

	}

}
