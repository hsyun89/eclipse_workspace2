package sort;

import java.util.ArrayList;
import java.util.Collections;

public class Prob_knum_1 {

	public static void main(String[] args) {
		int[] array = new int[] { 1, 5, 2, 6, 3, 7, 4 };
		int[][] commands = new int[][] { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };
		for (int data : solution(array, commands))
			System.out.println(data);
	}

	public static int[] solution(int[] array, int[][] commands) {
		ArrayList<Integer> list = new ArrayList<>();
		int[] answer = new int[commands.length];
		int start = 0;
		int end = 0;
		int index = 0;
		for (int i = 0; i < commands.length; i++) {
			start = commands[i][0];
			end = commands[i][1];
			index = commands[i][2];
			for (int j = start - 1; j < end; j++) {
				list.add(array[j]);
			}
			Collections.sort(list);
			answer[i] = list.get(index - 1);
			list.clear();
		}
		return answer;
	}

}
