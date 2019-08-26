package prob3;

import java.util.ArrayList;

public class DiscController {

	public static void main(String[] args) {
		int[][] jobs = { { 0, 3 }, { 1, 9 }, { 2, 6 } };
		System.out.println(solution(jobs));
		System.out.println(jobs.length);
	}

	public static int solution(int[][] jobs) {
		int answer = 0;
		ArrayList<int[]> list = new ArrayList<>();
		for (int i = 0; i < jobs.length; i++) {
			list.add(new int[] { jobs[i][0], jobs[i][1] });
		}
		return answer;
	}
}
