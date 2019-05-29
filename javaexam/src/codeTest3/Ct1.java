package codeTest3;

public class Ct1 {

	public static void main(String[] args) {

		// ¥ı«œ±‚~~~~~~~~~~
		int[] coeX = new int[] { 1, 1, 1 };
		int[] expX = new int[] { 0, 1, 2 };

		int[] coeY = new int[] { 1, 1, 1 };
		int[] expY = new int[] { 0, 2, 3 };

		printAdder(coeX,expX,coeY,expY);
	}

	static void printAdder(int[] coeX, int[] expX, int[] coeY, int[] expY) {
		int[] result = new int[4];

		int xIndex = 0;
		int yIndex = 0;
		int resultIndex = 0;
		while (xIndex <= 2 && yIndex <= 2) {
			if (expX[xIndex] == expY[yIndex]) {
				result[resultIndex] = coeX[xIndex] + coeY[yIndex];
				xIndex++;
				yIndex++;
				resultIndex++;
				continue;
			}
			if (expX[xIndex] < expY[yIndex]) {
				result[resultIndex] = coeX[xIndex];
				xIndex++;
				resultIndex++;
				continue;
			}
			if (expX[xIndex] > expY[yIndex]) {
				result[resultIndex] = coeY[yIndex];
				yIndex++;
				resultIndex++;
				continue;
			}
		}
		if (xIndex == 3 && yIndex != 3) {
			while (xIndex != yIndex) {
				result[resultIndex] = coeY[yIndex];
				resultIndex++;
				yIndex++;
			}

		}
		if (xIndex != 3 && yIndex == 3) {
			while (xIndex != yIndex) {
				result[resultIndex] = coeX[xIndex];
				resultIndex++;
				xIndex++;
			}
		}
		for (int data : result)
			System.out.println(data);

	}
}
