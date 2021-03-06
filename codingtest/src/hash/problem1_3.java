package hash;

import java.util.HashMap;
import java.util.Set;

public class problem1_3 {

	public static void main(String[] args) {
		System.out.println(solution(new String[] { "leo", "kiki", "eden" }, new String[] { "eden", "kiki" }));
	}

	public static String solution(String[] participant, String[] completion) {
		String answer = "";
		HashMap<Integer, String> hm = new HashMap<>();

		for (int i = 0; i < participant.length; i++) {
			hm.put(i, participant[i]);
		}

		Set<Integer> keyset = hm.keySet();
		for (int i = 0; i < completion.length; i++) {
			for (int key : keyset) {
				if (hm.get(key) == completion[i]) {
					hm.remove(key);
					break;
				}
			}
		}

		for (int key : keyset) {
			answer = hm.get(key);
		}
		return answer;
	}
}