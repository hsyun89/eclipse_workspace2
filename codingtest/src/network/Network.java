package network;

import java.util.ArrayList;

public class Network {

	public static void main(String[] args) {
		int[][] computers = new int[][] { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
		int n = 3;
		System.out.println(solution(n, computers));
	}

	public static int solution(int n, int[][] computers) {
		int answer = 0;
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			arr.add(i);
		}

		return answer;
	}
}
