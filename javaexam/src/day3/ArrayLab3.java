package day3;

public class ArrayLab3 {

	public static void main(String[] args) {
		int[] arrNum = new int[10];
		for (int i = 0; i < arrNum.length; i++) {
			arrNum[i] = (int) (Math.random() * 26) + 1;
		}

		char[] arrCh = new char[10];
		for (int i = 0; i < arrNum.length; i++) {
			arrCh[i] = (char) (arrNum[i] + 64);
		}

		for (int i = 0; i < arrNum.length; i++) {
			if (i == arrNum.length - 1)
				System.out.print(arrNum[i] + "\n");
			else
				System.out.print(arrNum[i] + ",");
		}

		for (int i = 0; i < arrCh.length; i++) {
			if (i == arrCh.length - 1)
				System.out.print(arrCh[i]);
			else
				System.out.print(arrCh[i] + ",");
		}
	}

}
