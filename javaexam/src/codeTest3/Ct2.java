package codeTest3;

public class Ct2 {

	public static void main(String[] args) {

		// ¥ı«œ±‚~~~~~~~~~~
		int[] coeX = new int[] { 1, 1, 1 };
		int[] expX = new int[] { 0, 1, 2 };

		int[] coeY = new int[] { 1, 1, 1 };
		int[] expY = new int[] { 0, 2, 3 };
		
		
		getAdder(coeX, expX, coeY, expY);
	}
	static int[] mul(int[] coeX, int[] expX, int[] coeY, int[] expY) {
		int[] result = new int[9];
		int xIndex = 0;
		int yIndex = 0;
		
		int[] expX1 = new int[] {expX[xIndex]+expY[yIndex]
				,expX[xIndex+1]+expY[yIndex]
				,expX[xIndex+2]+expY[yIndex]};
		int[] coeX1 = new int[]{coeX[xIndex]*coeY[yIndex]
				,coeX[xIndex+1]*coeY[yIndex]
				,coeX[xIndex+2]*coeY[yIndex]};
		
		int[] expX2 = new int[] {expX[xIndex]+expY[yIndex+1]
				,expX[xIndex+1]+expY[yIndex+1]
				,expX[xIndex+2]+expY[yIndex+1]};
		int[] coeX2 = new int[]{coeX[xIndex]*coeY[yIndex+1]
				,coeX[xIndex+1]*coeY[yIndex+1]
				,coeX[xIndex+2]*coeY[yIndex+1]};
		
		int[] expX3 = new int[] {expX[xIndex]+expY[yIndex+2]
				,expX[xIndex+1]+expY[yIndex+2]
				,expX[xIndex+2]+expY[yIndex+2]};
		int[] coeX3 = new int[]{coeX[xIndex]*coeY[yIndex+2]
				,coeX[xIndex+1]*coeY[yIndex+2]
				,coeX[xIndex+2]*coeY[yIndex+2]};
		
		getAdder(coeX1,expX1,coeX2,expX2);
		
		return result;
	}
	

	static int[] getAdder(int[] coeX, int[] expX, int[] coeY, int[] expY) {
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
		return result;

	}
}
