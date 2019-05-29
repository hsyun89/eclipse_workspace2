package day4;

public class TwoArrayLab2 {

	public static void main(String[] args) {
		int[][] arr = new int[][] { { 10, 20, 30, 40, 50 }, { 5, 10, 15 }, { 11, 22, 33, 44 },
				{ 9, 8, 7, 6, 5, 4, 3, 2, 1 } };
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				sum += arr[i][j];
			}
			System.out.println((i+1)+"행의 합은 " + sum + " 입니다.");
			sum = 0;
		}

	}

}
