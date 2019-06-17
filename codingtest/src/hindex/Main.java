package hindex;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		// int[] citations = { 3, 0, 6, 1, 5 };
		// int[] citations = { 1 };
		// int[] citations = { 0 };
		// int[] citations = { 50, 100, 150 };
		int[] citations = { 0, 0, 10, 10, 50, 50 };
		System.out.println(solution(citations));
	} 

	public static int solution(int[] citations) {
		int answer = 0;
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 0; i < citations.length; i++) {
			arr.add(citations[i]);
		}
		Collections.sort(arr);
		for (int h_idx = 0; h_idx <= arr.size(); h_idx++) {
			if (h_idx == 0) {
				answer = 0;
			} else {
				if (arr.get(arr.size() - h_idx) >= h_idx) {
					answer = h_idx;
				}
			}
		}
		return answer;
	}

}
