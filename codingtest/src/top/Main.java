package top;

public class Main {

	public static void main(String[] args) {
		//int[] h1 = new int[] { 6, 9, 5, 7, 4 };
		//int[] h1 = new int[] { 6,9 };
		//int[] h1 = new int[] { 6, 6 };
		int[] h1 = new int[] { 7, 5, 5 };
		for (int data : solution(h1)) {
			System.out.println(data);
		}
	}

	public static int[] solution(int[] heights) {
		int[] answer = {};
		int length = heights.length;
		int idx[] = new int[length];

		if (length > 2) {
			for (int i = 0; i < length; i++) {
				idx[i] = i + 1;
			}

			int[] result = new int[length];
			for (int i = length - 1; i > 0; i--) {
				for (int j = 1; j < i+1; j++) {
					if (heights[i - j] > heights[i]) {
						result[i] = idx[i - j];
						break;
					}
				}
			}
			answer = result;
			return answer;
		} else {
			if (heights[0] > heights[1]) {
				int[] result = new int[] { 1, 0 };
				answer = result;
			} else {
				int[] result = new int[] { 0, 0 };
				answer = result;
			}
 
			return answer;
		}
	}

}
