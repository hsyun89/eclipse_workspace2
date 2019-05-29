package day4;

public class TwoArrayLab1 {

	public static void main(String[] args) {
		char[][] arr = new char[][] { { 'B', 'C', 'A', 'A' }, { 'C', 'C', 'B', 'B' }, { 'D', 'A', 'A', 'D' } };
		int[] alphaCount = new int[4];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == 'A')
					alphaCount[0]++;
				else if (arr[i][j] == 'B')
					alphaCount[1]++;
				else if (arr[i][j] == 'C')
					alphaCount[2]++;
				else
					alphaCount[3]++;
			}
		}
		for (int i = 0; i < 4; i++) {
			System.out.println((char)(i + 'A') + "는 " + alphaCount[i] + "개 입니다.");
		}

	}

}
